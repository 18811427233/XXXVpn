package com.demo.xxxvpn.domain.usecase

import com.demo.xxxvpn.domain.repository.TunnelRepository
import javax.inject.Inject

class MonitorDeviceIdUseCase @Inject constructor(
    private val repository: TunnelRepository
) {

    suspend operator fun invoke() = repository.getDeviceId()
}