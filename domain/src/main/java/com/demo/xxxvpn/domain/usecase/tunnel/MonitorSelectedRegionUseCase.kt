package com.demo.xxxvpn.domain.usecase.tunnel

import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.domain.repository.CacheRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Monitor user selected region
 */
class MonitorSelectedRegionUseCase @Inject constructor(
    private val cacheRepository: CacheRepository,
) {

    suspend operator fun invoke(): Flow<Region?> = cacheRepository.monitorRegion()
}
