package com.demo.xxxvpn.domain.usecase

import com.demo.xxxvpn.domain.usecase.ad.GetAdShowRuleCanShowUseCase
import javax.inject.Inject

class HadLoadADUseCase @Inject constructor(
    private val ruleCanShowUseCase: GetAdShowRuleCanShowUseCase,
) {

    suspend operator fun invoke(key: String) = ruleCanShowUseCase(key, false)
}