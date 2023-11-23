package com.demo.xxxvpn.data.repository

import android.content.ClipData
import android.content.ClipboardManager
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.withContext
import com.demo.xxxvpn.domain.entity.NetworkState
import com.demo.xxxvpn.domain.qualifiers.ApplicationScope
import com.demo.xxxvpn.domain.qualifiers.IoDispatcher
import com.demo.xxxvpn.domain.repository.AndroidSystemRepository
import timber.log.Timber
import java.io.File
import javax.inject.Inject

class AndroidSystemRepositoryImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val clipboardManager: ClipboardManager,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @ApplicationScope private val applicationScope: CoroutineScope
) : AndroidSystemRepository {

    override val getNetworkState = flow {
        emit(getCurrentConnectivityState())
        emitAll(monitorNetworkCallback)
    }.flowOn(ioDispatcher)

    @OptIn(FlowPreview::class)
    private val monitorNetworkCallback = callbackFlow {
        val networkStatusCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                Timber.d("onAvailable")
                trySend(NetworkState.Connected)
            }

            override fun onLost(network: Network) {
                Timber.d("onLost")
                trySend(getCurrentConnectivityState())
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                Timber.d("onCapabilitiesChanged")
                trySend(getCurrentConnectivityState())
            }
        }

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.apply {
            registerNetworkCallback(request, networkStatusCallback)
            registerDefaultNetworkCallback(networkStatusCallback)
        }

        awaitClose {
            connectivityManager.unregisterNetworkCallback(networkStatusCallback)
        }
    }.flowOn(ioDispatcher)
        .debounce(CONNECTIVITY_DEBOUNCE_INTERVAL)
        .shareIn(applicationScope, SharingStarted.WhileSubscribed())

    override suspend fun copyTextToClipboard(label: String, text: String) =
        withContext(ioDispatcher) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(label, text))
        }

    @Suppress("DEPRECATION")
    private fun getCurrentConnectivityState(): NetworkState =
        if (connectivityManager.activeNetworkInfo?.isConnected == true) NetworkState.Connected else NetworkState.Disconnected

    private companion object {
        const val CONNECTIVITY_DEBOUNCE_INTERVAL = 150L
    }

    override suspend fun doesFileExist(path: String?): Boolean {
        if (path.isNullOrBlank()) {
            return false
        }
        return withContext(ioDispatcher) {
            File(path).exists()
        }
    }
}