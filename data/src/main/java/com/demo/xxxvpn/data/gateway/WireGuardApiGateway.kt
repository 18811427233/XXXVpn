package com.demo.xxxvpn.data.gateway

import com.wireguard.android.backend.Statistics
import com.wireguard.android.backend.Tunnel
import com.wireguard.config.Config

interface WireGuardApiGateway {
    /**
     * Connect to tunnel
     *
     * @param tunnel the wireguard tunnel interface
     * @param config the wireguard config
     */
    suspend fun connectTunnel(tunnel: Tunnel, config: Config): Tunnel.State

    /**
     * Disconnect the current running tunnel
     *
     * @param tunnel the wireguard tunnel interface
     */
    suspend fun disconnectTunnel(tunnel: Tunnel): Tunnel.State

    /**
     * Get current tunnel connection state
     *
     * @param tunnel the wireguard tunnel interface
     * @return [Tunnel.State]
     */
    suspend fun getConnectionState(tunnel: Tunnel): Tunnel.State

    /**
     * Get current tunnel statistics
     *
     * @param tunnel the wireguard tunnel interface
     * @return [Tunnel.State]
     */
    suspend fun getTunnelStatistics(tunnel: Tunnel): Statistics
}