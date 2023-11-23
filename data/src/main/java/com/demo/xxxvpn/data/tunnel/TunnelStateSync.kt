package com.demo.xxxvpn.data.tunnel

/**
 * Interface to handle Tunnel State Synchronization
 */
interface TunnelStateSync {
    /**
     * Notify that tunnel is currently in Loading State
     */
    suspend fun notifyTunnelStateLoading()

    /**
     * Notify that tunnel is currently in Connected State
     */
    suspend fun notifyTunnelStateConnected()

    /**
     * Notify that tunnel is currently in Disconnected State
     */
    suspend fun notifyTunnelStateDisconnected()
}