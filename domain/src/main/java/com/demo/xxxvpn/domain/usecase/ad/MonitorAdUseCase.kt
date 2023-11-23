package com.demo.xxxvpn.domain.usecase.ad

import com.demo.xxxvpn.domain.repository.ADRepository
import com.demo.xxxvpn.domain.repository.CacheRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class MonitorAdUseCase @Inject constructor(
    private val adRepository: ADRepository,
    private val cacheRepository: CacheRepository,
    private val preLoadAdUseCase: PreLoadAdUseCase,
) {

    suspend operator fun invoke(key: String, stopServer: () -> Unit): Boolean {
        val rule = cacheRepository.monitorADConfig(key).first()
        return if (rule != null) {
            adRepository.monitorPageAd(key, rule.adId).collectLatest {
                println("$key monitorAd:$it")
                if (!it) {
                    stopServer()
                    preLoadAdUseCase(key)
                }
            }
            true
        } else {
            false
        }
    }
}