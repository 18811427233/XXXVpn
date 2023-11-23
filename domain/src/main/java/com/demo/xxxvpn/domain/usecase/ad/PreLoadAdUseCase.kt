package com.demo.xxxvpn.domain.usecase.ad

import com.demo.xxxvpn.domain.repository.ADRepository
import com.demo.xxxvpn.domain.repository.CacheRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PreLoadAdUseCase @Inject constructor(
    private val adRepository: ADRepository,
    private val cacheRepository: CacheRepository,
    private val getAdShowRuleCanShowUseCase: GetAdShowRuleCanShowUseCase,
) {

    suspend operator fun invoke(key: String) {
        if (getAdShowRuleCanShowUseCase(key, true)) {
            val rule = cacheRepository.monitorADConfig(key).first()
            adRepository.loadPageAd(key, rule?.adId ?: "")
        }
    }
}