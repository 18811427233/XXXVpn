package com.demo.xxxvpn.data.mapper

import com.wireguard.android.backend.Tunnel
import com.demo.xxxvpn.domain.entity.TunnelState
import javax.inject.Inject

class TunnelStateMapper @Inject constructor() {
    operator fun invoke(state: Tunnel.State): TunnelState = when (state) {
        Tunnel.State.UP -> TunnelState.Connected
        Tunnel.State.DOWN -> TunnelState.Disconnected
        Tunnel.State.TOGGLE -> TunnelState.Toggle
    }
}