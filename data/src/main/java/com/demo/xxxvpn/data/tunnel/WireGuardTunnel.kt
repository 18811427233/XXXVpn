package com.demo.xxxvpn.data.tunnel

import com.wireguard.android.backend.Tunnel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import com.demo.xxxvpn.data.cache.TunnelSharedFlow
import com.demo.xxxvpn.domain.keys.WireGuardConfigKeys
import com.demo.xxxvpn.domain.qualifiers.ApplicationScope
import javax.inject.Inject

/**
 * Class to manage tunnel state for the WireGuard VPN protocol
 * This class extends [Tunnel] from the WireGuard SDK
 *
 * This class also manages and listens to state changes performed by the WireGuard SDK, such as
 * [Tunnel.State.TOGGLE], [Tunnel.State.DOWN], [Tunnel.State.UP] in the callback [onStateChange].
 * When the WireGuard tunnel state changes, [tunnelState] will be updated with the latest change,
 * and it will emit its state as SharedFlow to all the subscribers
 */
class WireGuardTunnel @Inject constructor(
    @ApplicationScope private val applicationScope: CoroutineScope,
    private val tunnelSharedFlow: TunnelSharedFlow
) : Tunnel, TunnelStateSync {
    val tunnelState: Flow<Tunnel.State>
        get() = tunnelSharedFlow
            .monitor()
            .shareIn(applicationScope, SharingStarted.Lazily)

    override suspend fun notifyTunnelStateLoading() = tunnelSharedFlow.set(Tunnel.State.TOGGLE)

    override suspend fun notifyTunnelStateDisconnected() = tunnelSharedFlow.set(Tunnel.State.DOWN)

    override suspend fun notifyTunnelStateConnected() = tunnelSharedFlow.set(Tunnel.State.UP)

    override fun getName() = WireGuardConfigKeys.TUNNEL_NAME

    override fun onStateChange(newState: Tunnel.State) {
        applicationScope.launch {
            tunnelSharedFlow.set(newState)
        }
    }
}