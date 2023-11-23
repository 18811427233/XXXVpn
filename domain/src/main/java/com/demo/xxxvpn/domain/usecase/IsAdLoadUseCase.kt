package com.demo.xxxvpn.domain.usecase

import com.demo.xxxvpn.domain.repository.ADRepository
import javax.inject.Inject

class IsAdLoadUseCase @Inject constructor(
    private val adRepository: ADRepository,
) {
    operator fun invoke(adId: String) =  adRepository.isPageAdLoad(adId)
}