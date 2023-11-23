package com.demo.xxxvpn.domain.usecase.ad

import com.demo.xxxvpn.domain.repository.CacheRepository
import javax.inject.Inject

class MonitorAdEventUseCase @Inject constructor(
    private val cacheRepository: CacheRepository,
) {

    operator fun invoke() = cacheRepository.monitorADEvent()
}