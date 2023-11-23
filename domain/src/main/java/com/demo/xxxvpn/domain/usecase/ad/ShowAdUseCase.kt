package com.demo.xxxvpn.domain.usecase.ad

import com.demo.xxxvpn.domain.entity.network.AD_APP_LAUNCH
import com.demo.xxxvpn.domain.entity.network.AD_DEFAULT_POSITION
import com.demo.xxxvpn.domain.repository.ADRepository
import com.demo.xxxvpn.domain.repository.CacheRepository
import kotlinx.coroutines.flow.first
import java.util.Calendar
import javax.inject.Inject

class ShowAdUseCase @Inject constructor(
    private val adRepository: ADRepository,
    private val cacheRepository: CacheRepository,
    private val getAdShowRuleCanShowUseCase: GetAdShowRuleCanShowUseCase,
) {

    suspend operator fun invoke(key: String): Boolean {
        val rule = cacheRepository.monitorADConfig(key).first()
        return if (rule != null) {
            if (adRepository.isPageAdLoad(rule.adId)) {
                if (getAdShowRuleCanShowUseCase(key, false)) {
                    val adKey = if (rule.showCount == -1) {
                        AD_DEFAULT_POSITION
                    } else {
                        key
                    }
                    if (rule.frequencyDay == 0) {
                        adRepository.showEveryTime(adKey)
                    }
                    if (key != AD_APP_LAUNCH) {
                        val count = cacheRepository.monitorInt(adKey.getADCountKey()).first() ?: 0
                        cacheRepository.putInt(adKey.getADCountKey(), count + 1)
                        cacheRepository.putLong(
                            adKey.getADLastTimeKey(),
                            Calendar.getInstance().timeInMillis
                        )
                        if (count == 0) {
                            cacheRepository.putLong(
                                adKey.getADTimeKey(),
                                Calendar.getInstance().timeInMillis
                            )
                        }
                    }
                    println("$key 展示广告")
                    adRepository.showPageAd(key, rule.adId)
                    true
                } else {
                    false
                }
            } else {
                false
            }
        } else {
            false
        }
    }
}