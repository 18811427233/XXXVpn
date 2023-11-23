package com.demo.xxxvpn.domain.usecase.tunnel

import com.demo.xxxvpn.domain.entity.TunnelState
import com.demo.xxxvpn.domain.repository.TunnelRepository
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MonitorTunnelStateUseCase @Inject constructor(
    private val tunnelRepository: TunnelRepository,
    private val resetLastConnectedTimestampUseCase: ResetLastConnectedTimestampUseCase,
) {
    operator fun invoke() = tunnelRepository
        .monitorTunnelStateChanged()
        .onEach {
            if (it == TunnelState.Disconnected) {
                resetLastConnectedTimestampUseCase()
            }
        }
}