package com.demo.xxxvpn.domain.repository

import kotlinx.coroutines.flow.Flow
import com.demo.xxxvpn.domain.entity.HandshakeState
import com.demo.xxxvpn.domain.entity.TunnelState
import com.demo.xxxvpn.domain.entity.TunnelStatistics

interface TunnelRepository {
    /**
     * Connect to tunnel
     *
     * @param region the region of the VPN server
     */
    suspend fun connectTunnel(region: String, port: Int?)

    /**
     * Disconnect the current running tunnel
     */
    suspend fun disconnectTunnel()

    /**
     * Notify that tunnel is currently in Loading State
     */
    suspend fun notifyTunnelLoading()

    /**
     * Notify that tunnel is currently in Connected State
     */
    suspend fun notifyTunnelConnected()

    /**
     * Notify that tunnel is currently in Disconnected State
     */
    suspend fun notifyTunnelDisconnected()

    /**
     * Get the current tunnel connection state
     *
     * @return state as [TunnelState]
     */
    suspend fun getCurrentTunnelConnectionState(): TunnelState

    /**
     * Monitor tunnel state changed
     *
     * @return Flow of [TunnelState]
     */
    fun monitorTunnelStateChanged(): Flow<TunnelState>

    /**
     * Get the current connected tunnel statistics
     */
    suspend fun getConnectionStatistics(): TunnelStatistics

    /**
     * Get the current connected tunnel handshake state
     */
    suspend fun getHandshakeState(): HandshakeState

    /**
     * Check if a public webroot is reachable
     */
    suspend fun isPublicWebrootReachable(): Boolean

    suspend fun getDeviceId(): String?
}

