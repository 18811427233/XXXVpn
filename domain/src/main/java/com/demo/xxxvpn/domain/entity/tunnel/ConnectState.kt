package com.demo.xxxvpn.domain.entity.tunnel

import com.demo.xxxvpn.domain.entity.HandshakeState
import com.demo.xxxvpn.domain.entity.TunnelStatistics
import com.demo.xxxvpn.domain.entity.network.Region

sealed interface ConnectState {
    data object Disconnected : ConnectState

    data object Connecting : ConnectState

    data object Reconnecting : ConnectState

    data class Connected(
        val statistics: TunnelStatistics,
        val handshakeState: HandshakeState,
        val region: Region?
    ) : ConnectState
}