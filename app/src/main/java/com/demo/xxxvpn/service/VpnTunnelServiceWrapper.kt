package com.demo.xxxvpn.service

interface VpnTunnelServiceWrapper {

    /**
     * Start a VPN Tunnel as a Service
     */
    fun startTunnelService(portIndex: Int, slice: Boolean)

    /**
     * Stop a VPN Tunnel running service
     *
     * @see InfiniteVpnService
     */
    fun stopTunnelService(slice: Boolean)
}