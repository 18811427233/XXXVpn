package com.demo.xxxvpn.service

import android.content.Context
import android.content.Intent
import com.demo.xxxvpn.service.InfiniteVpnService.Companion.EXTRA_IS_TOGGLED_FROM_PAGE
import com.demo.xxxvpn.service.InfiniteVpnService.Companion.EXTRA_PORT_INDEX
import com.demo.xxxvpn.service.InfiniteVpnService.State
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Wrapper class for [InfiniteVpnService]
 */
@Singleton
class VpnTunnelServiceWrapperImpl @Inject constructor(
    @ApplicationContext private val applicationContext: Context
) : VpnTunnelServiceWrapper {
    override fun startTunnelService(portIndex: Int, slice: Boolean) =
        launchVpnTunnelService(State.Start, portIndex, slice)

    override fun stopTunnelService(slice: Boolean) = launchVpnTunnelService(State.Stop, 0, slice)

    private fun launchVpnTunnelService(state: State, portIndex: Int, slice: Boolean) {
        val intent = Intent(applicationContext, InfiniteVpnService::class.java).apply {
            action = state.name
            putExtra(EXTRA_PORT_INDEX, portIndex)
            putExtra(EXTRA_IS_TOGGLED_FROM_PAGE, slice)
        }

        try {
            Timber.d("Starting Foreground Service (Action: ${state.name})")
            applicationContext.startService(intent)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }
}