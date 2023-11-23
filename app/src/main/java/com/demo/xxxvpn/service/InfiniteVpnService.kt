package com.demo.xxxvpn.service

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PowerManager
import com.demo.xxxvpn.domain.entity.tunnel.ConnectState
import com.demo.xxxvpn.domain.qualifiers.IoDispatcher
import com.demo.xxxvpn.domain.repository.CacheRepository
import com.demo.xxxvpn.domain.usecase.tunnel.ConnectTunnelUseCase
import com.demo.xxxvpn.domain.usecase.tunnel.DisconnectTunnelUseCase
import com.demo.xxxvpn.domain.usecase.tunnel.MonitorConnectStateUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class InfiniteVpnService : android.net.VpnService() {

    @Inject
    lateinit var connectTunnelUseCase: ConnectTunnelUseCase

    @Inject
    lateinit var disconnectTunnelUseCase: DisconnectTunnelUseCase

    @Inject
    lateinit var powerManager: PowerManager

    @Inject
    lateinit var monitorConnectStateUseCase: MonitorConnectStateUseCase

    @Inject
    lateinit var cacheRepository: CacheRepository

    @Inject
    @IoDispatcher
    lateinit var ioDispatcher: CoroutineDispatcher

    private val coroutineScope by lazy {
        CoroutineScope(SupervisorJob() + ioDispatcher)
    }
    private var startServiceJob: Job? = null
    private var sliceMode: Boolean = false
    private var lastConnectionState: ConnectState = ConnectState.Disconnected

    /**
     * Flag to determined whether service is started from toggle button in home page
     */
    private var isServiceStartedFromHomePageToggle: Boolean = false

    /**
     * Flag to determined whether service is stopped from Always-on VPN
     * Default true because there's no mechanism to detect if it's stopped by Always-On VPN
     * So, everything else is false
     */
    private var isServiceStoppedFromAlwaysOnVpn: Boolean = true
    private var wakeLock: PowerManager.WakeLock? = null

    enum class State {
        /**
         * Flag to start the service
         */
        Start,

        /**
         * Flag to stop the service
         */
        Stop
    }

    override fun onCreate() {
        super.onCreate()
        monitorConnectionState()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            isServiceStartedFromHomePageToggle =
                intent.extras.getIsToggledFromHomePageExtra() == true

            when (intent.action) {
                State.Start.name -> startTunnelService(intent.extras?.getPortIndex() ?: 0)
                State.Stop.name -> stopTunnelService()

                /**
                 * Intent action passed by the Android System when a user enables the Always-on VPN toggle
                 */
                SERVICE_INTERFACE -> {
                    Timber.d("Service started by Always-on VPN")
                    startTunnelService(intent.extras?.getPortIndex() ?: 0)
                }

                else -> Timber.e("Unknown action passed to the service")
            }
        } else {
            Timber.d("Intent is null. Most likely service is restarted by the Android System because of low memory")
        }

        return START_STICKY
    }

    /**
     * Enable partial wake lock so that service will not be stopped by doze mode. Partial wakeLock
     * will only lock on CPU power, not display power.
     * Timeout is indefinite until service is destroyed or stopped, then wakeLock will be released
     */
    @SuppressLint("WakelockTimeout")
    private fun initWakeLock() {
        wakeLock = powerManager.newWakeLock(
            PowerManager.PARTIAL_WAKE_LOCK,
            "${InfiniteVpnService::class.simpleName}::wakeLock"
        ).apply {
            // acquire the Wake Lock without timeout.
            acquire()
        }
    }

    private fun releaseWakeLock() {
        wakeLock
            ?.let { if (it.isHeld) it.release() }
            ?.also { wakeLock = null }
    }

    private fun monitorConnectionState() {
        coroutineScope.launch {
            monitorConnectStateUseCase()
                .collectLatest {
                    if (!sliceMode) {
                        Timber.e("==Jacob===="+it.toString())
                        lastConnectionState = it
                    }
                }
        }
    }

    /**
     * Start the VPN tunnel service
     * Vpn Region can be null, because it can be started by Always-on VPN from the Android settings
     * In that case, it will default to the last used region
     *
     * In the case of Credential, when null, it will automatically used the LU region. Any region is fine,
     * because it will be replaced later when the user select another region.
     *
     * @param extras intent extras as [Bundle]
     */
    private fun startTunnelService(portIndex: Int) {
        cancelCoroutineJob()
        startServiceJob = coroutineScope.launch {
            connectToTunnel(portIndex)
        }
    }

    /**
     * Connect to tunnel with the given region
     *
     * @param region the region of the VPN server
     */
    private suspend fun connectToTunnel(portIndex: Int) {
        runCatching {
            Timber.d("Connecting to tunnel")
            connectTunnelUseCase(
                cacheRepository.monitorRegion().first(),
                portIndex
            )
        }.onSuccess {
            Timber.d("Successfully connect to tunnel")
            initWakeLock()
        }.onFailure {
            Timber.e("Failed connecting to tunnel, stopping service now! $it")
            stopTunnelService()
        }
    }

    private fun stopTunnelService() {
        coroutineScope.launch {
            runCatching {
                isServiceStoppedFromAlwaysOnVpn = false
                disconnectTunnelUseCase()
            }.onSuccess {
                Timber.d("Tunnel has been disconnected!")
            }.onFailure {
                Timber.e(it)
            }

            cancelCoroutineJob()
            coroutineContext.cancelChildren()
            stopSelf()
        }
    }

    private fun cancelCoroutineJob() {
        if (startServiceJob?.isActive == true) {
            startServiceJob?.cancel()
        }
    }

    override fun onDestroy() {
        releaseWakeLock()
        startServiceJob = null
        coroutineScope.cancel("VpnTunnelService has been destroyed!")
        super.onDestroy()
    }


    private fun Bundle?.getPortIndex() =
        this?.getInt(EXTRA_PORT_INDEX)

    private fun Bundle?.getIsToggledFromHomePageExtra() =
        this?.getBoolean(EXTRA_IS_TOGGLED_FROM_PAGE)

    internal companion object {
        const val EXTRA_PORT_INDEX = "port_index"
        const val EXTRA_IS_TOGGLED_FROM_PAGE = "is_toggled_from_home_page"
        const val EXTRA_SLICE = "slice"
    }
}