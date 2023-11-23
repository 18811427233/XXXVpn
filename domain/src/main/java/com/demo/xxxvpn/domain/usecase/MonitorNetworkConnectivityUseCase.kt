package com.demo.xxxvpn.domain.usecase

import kotlinx.coroutines.flow.Flow
import com.demo.xxxvpn.domain.entity.NetworkState
import com.demo.xxxvpn.domain.repository.AndroidSystemRepository
import javax.inject.Inject

/**
 * Use Case to receive updates regarding device connectivity state
 */
class MonitorNetworkConnectivityUseCase @Inject constructor(
    private val androidSystemRepository: AndroidSystemRepository
) {

    /**
     * Invoke
     *
     * @return Flow of [NetworkState]
     */
    operator fun invoke(): Flow<NetworkState> =
        androidSystemRepository.getNetworkState
}