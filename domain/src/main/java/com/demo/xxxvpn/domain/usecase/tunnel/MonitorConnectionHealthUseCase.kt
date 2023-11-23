package com.demo.xxxvpn.domain.usecase.tunnel

import com.demo.xxxvpn.domain.entity.HandshakeState
import com.demo.xxxvpn.domain.entity.NetworkState
import com.demo.xxxvpn.domain.entity.TunnelState
import com.demo.xxxvpn.domain.entity.tunnel.ConnectState
import com.demo.xxxvpn.domain.repository.TunnelRepository
import com.demo.xxxvpn.domain.usecase.MonitorNetworkConnectivityUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.isActive
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
class MonitorConnectStateUseCase @Inject constructor(
    private val monitorTunnelStateUseCase: MonitorTunnelStateUseCase,
    private val monitorNetworkConnectivityUseCase: MonitorNetworkConnectivityUseCase,
    private val monitorSelectedRegionUseCase: MonitorSelectedRegionUseCase,
    private val saveLastConnectedTimestampUseCase: SaveLastConnectedTimestampUseCase,
    private val tunnelRepository: TunnelRepository,
) {
    operator fun invoke(): Flow<ConnectState> =
        combine(
            monitorTunnelStateUseCase(),
            monitorNetworkConnectivityUseCase()
        ) { tunnelState, networkState ->
            tunnelState to networkState
        }.flatMapLatest { (tunnelState, networkState) ->
            when (tunnelState) {
                TunnelState.Connected -> monitorTunnelConnectedState(
                    networkState = networkState,
                )

                TunnelState.Disconnected -> flowOf(ConnectState.Disconnected)
                TunnelState.Toggle -> flowOf(ConnectState.Connecting)
            }
        }

    /*
    * This flow tracks when device is connected to the Android VPN Gateway, but it doesn't mean
    * that it's connected to the VPN Server. The gateway might not be connected to the VPN server, hence
    * there are 2 states:
    * Connected = Connected to Android VPN Gateway + Connected to VPN Server
    * Reconnecting = Connected to Android VPN Gateway + NOT Connected to VPN Server
    * This flow regularly fetch the tunnel handshake state every N seconds in order to get the latest
    * handshake state. The Handshake state will be used to determine
    */
    private fun monitorTunnelConnectedState(networkState: NetworkState): Flow<ConnectState> =
        flow {
            while (currentCoroutineContext().isActive) {
                emit(tunnelRepository.getHandshakeState())
                delay(FETCH_STATISTICS_DELAY_INTERVAL)
            }
        }.map { handshakeState ->
            mergeHandshakeWithPublicWebrootReachableState(handshakeState = handshakeState)
        }.flatMapLatest { handshakeState ->
            when {
                isConnectedToVpnServer(networkState, handshakeState) -> {
                    monitorVpnConnectedState(handshakeState)
                }

                isNeverConnectedToVpnServer(networkState, handshakeState) -> {
                    flowOf(ConnectState.Connecting)
                }

                else -> flowOf(ConnectState.Reconnecting)
            }
        }

    /**
     * This flow guarantees that device is connected to both Android VPN Gateway & VPN Server
     * Connected = Connected to Android VPN Gateway + Connected to VPN Server
     */
    private fun monitorVpnConnectedState(handshakeState: HandshakeState) =
        flow {
            emit(
                ConnectState.Connected(
                    statistics = tunnelRepository.getConnectionStatistics(),
                    handshakeState = handshakeState,
                    region = monitorSelectedRegionUseCase().first()
                )
            )
        }.onEach {
            saveLastConnectedTimestampUseCase()
        }

    /**
     * This method checks whether the Android VPN Gateway is actually connected to the VPN server
     * It checks whether device has an internet connection
     * Then, it also checks whether handshake was received recently from peer connection
     */
    private fun isConnectedToVpnServer(networkState: NetworkState, handshakeState: HandshakeState) =
        networkState == NetworkState.Connected
                && (handshakeState == HandshakeState.STRONG || handshakeState == HandshakeState.WEAK)

    /**
     * This method checks whether the Android VPN Gateway is actually connected to the VPN server
     * It checks whether device has an internet connection
     * Then, it also checks whether handshake was never received from peer previously, to determine
     * that the user was connected for the first time
     */
    private fun isNeverConnectedToVpnServer(
        networkState: NetworkState,
        handshakeState: HandshakeState
    ) = networkState == NetworkState.Connected && handshakeState == HandshakeState.NEVER

    /**
     * This method combines the Handshake state and the network reachable state by pinging a public
     * webroot to see if the device is actually connected to an active network. The WireGuard library
     * Handshake state can be miscalculated by as much as 120-180 seconds, because that is the amount of time
     * it takes for WireGuard to renew it's Handshake state, and there's no way of controlling it.
     * By combining this, we can dramatically reduce the miscalculation to [FETCH_STATISTICS_DELAY_INTERVAL] seconds.
     *
     * This method checks if a prior Handshake has been established, and then it checks whether the
     * public webroot is reachable, and if both condition are not met, it will alter the Handshake state to WEAK
     * regardless of the Handshake state returned by WireGuard statistics
     */
    private suspend fun mergeHandshakeWithPublicWebrootReachableState(handshakeState: HandshakeState) =
        if (handshakeState != HandshakeState.NEVER && !tunnelRepository.isPublicWebrootReachable()) {
            HandshakeState.WEAK
        } else {
            handshakeState
        }

    companion object {
        const val FETCH_STATISTICS_DELAY_INTERVAL = 1_000L
    }
}

