package com.demo.xxxvpn.domain.usecase

import com.demo.xxxvpn.domain.repository.CacheRepository
import javax.inject.Inject

/**
 * Use Case to get the current user's VPN connection timestamp
 */
class MonitorCurrentConnectedTimestampUseCase @Inject constructor(
    private val cacheRepository: CacheRepository,
) {
    suspend operator fun invoke() =
        cacheRepository.monitorLong(CacheRepository.CACHE_KEY_LAST_CONNECT_TIME)
}