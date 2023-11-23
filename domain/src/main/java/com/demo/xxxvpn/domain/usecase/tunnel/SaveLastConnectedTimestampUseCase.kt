package com.demo.xxxvpn.domain.usecase.tunnel

import com.demo.xxxvpn.domain.repository.CacheRepository
import com.demo.xxxvpn.domain.repository.CacheRepository.Companion.CACHE_KEY_LAST_CONNECT_TIME
import kotlinx.coroutines.flow.first
import java.util.Calendar
import javax.inject.Inject

class SaveLastConnectedTimestampUseCase @Inject constructor(
    private val cacheRepository: CacheRepository
) {
    suspend operator fun invoke() {
        if (cacheRepository.monitorLong(CACHE_KEY_LAST_CONNECT_TIME).first() == 0L) {
            cacheRepository.putLong(
                CACHE_KEY_LAST_CONNECT_TIME,
                Calendar.getInstance().timeInMillis
            )
        }
    }
}