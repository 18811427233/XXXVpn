package com.demo.xxxvpn.domain.usecase.tunnel

import com.demo.xxxvpn.domain.repository.CacheRepository
import javax.inject.Inject

/**
 * Use Case to reset the current user's VPN connection timestamp
 */
class ResetLastConnectedTimestampUseCase @Inject constructor(
    private val cacheRepository: CacheRepository
) {
    suspend operator fun invoke() =
        cacheRepository.putLong(CacheRepository.CACHE_KEY_LAST_CONNECT_TIME, 0)
}