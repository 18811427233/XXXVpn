package com.demo.xxxvpn.domain.usecase.tunnel

import com.demo.xxxvpn.domain.entity.TunnelState
import com.demo.xxxvpn.domain.repository.TunnelRepository
import javax.inject.Inject

/**
 * Disconnect VPN Tunnel Use Case
 */
class DisconnectTunnelUseCase @Inject constructor(
    private val tunnelRepository: TunnelRepository,
    private val resetLastConnectedTimestampUseCase: ResetLastConnectedTimestampUseCase
) {
    /**
     * Disconnect from a the current VPN Tunnel
     *
     * Checks whether the current state is [TunnelState.Disconnected]. If true, then it will notify
     * that tunnel is actually Disconnected and throw a [RuntimeException], otherwise it will
     * disconnect the current tunnel, while also resetting the last saved connected timestamp
     * to 0 after the tunnel is disconnected.
     */
    suspend operator fun invoke() {
        // In case when tunnel is already disconnected, notify that it's disconnected
        // to make sure that state is always in sync
        if (tunnelRepository.getCurrentTunnelConnectionState() == TunnelState.Disconnected) {
            tunnelRepository.notifyTunnelDisconnected()
            throw RuntimeException("Tunnel is already disconnected!")
        }

        tunnelRepository.disconnectTunnel()
        resetLastConnectedTimestampUseCase()
    }
}