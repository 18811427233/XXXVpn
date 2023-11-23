package com.demo.xxxvpn.data.facade

import com.wireguard.android.backend.GoBackend
import com.wireguard.android.backend.Statistics
import com.wireguard.android.backend.Tunnel
import com.wireguard.config.Config
import com.demo.xxxvpn.data.gateway.WireGuardApiGateway
import javax.inject.Inject

class WireGuardApiGatewayImpl @Inject constructor(
    private val goBackend: GoBackend
) : WireGuardApiGateway {

    override suspend fun connectTunnel(tunnel: Tunnel, config: Config): Tunnel.State =
        goBackend.setState(
            tunnel,
            Tunnel.State.UP,
            config
        )

    override suspend fun disconnectTunnel(tunnel: Tunnel): Tunnel.State =
        goBackend.setState(
            tunnel,
            Tunnel.State.DOWN,
            null
        )

    override suspend fun getConnectionState(tunnel: Tunnel): Tunnel.State =
        goBackend.getState(tunnel)


    override suspend fun getTunnelStatistics(tunnel: Tunnel): Statistics =
        goBackend.getStatistics(tunnel)
}