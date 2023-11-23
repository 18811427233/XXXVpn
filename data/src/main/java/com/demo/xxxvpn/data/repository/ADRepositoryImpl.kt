package com.demo.xxxvpn.data.repository

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.demo.xxxvpn.domain.ADEvent
import com.demo.xxxvpn.domain.entity.network.AD_APP_LAUNCH
import com.demo.xxxvpn.domain.repository.ADRepository
import com.demo.xxxvpn.domain.repository.CacheRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import timber.log.Timber
import javax.inject.Inject

class ADRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val adRequest: AdRequest,
    private val adManagerAdRequest: AdManagerAdRequest,
    private val cacheRepository: CacheRepository,
    private val activityLifecycleHandler: ActivityLifecycleHandler,
) : ADRepository {

    private var currentKey: String = ""
    private val adMap = mutableMapOf<String, Any?>()
    private val adFlowMap = mutableMapOf<String, MutableStateFlow<Boolean>?>()
    private val adIdLoadLock = mutableMapOf<String, Boolean>()
    private val everyTimeMap = mutableMapOf<String, Boolean>()

    override fun init() {
        MobileAds.initialize(context)
//        val testDeviceIds = listOf("75c30099-8dc8-48b8-a866-41190941a6cc")
//        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
//        MobileAds.setRequestConfiguration(configuration)
    }

    override fun monitorPageAd(key: String, adId: String): MutableStateFlow<Boolean> {
        val mapKey = "$adId-$key"
        if (adFlowMap[mapKey] == null) {
            adFlowMap[mapKey] = MutableStateFlow(false)
        }
        return adFlowMap[mapKey]!!
    }

    override fun notifyPageAdState(adId: String, load: Boolean) {
        val map = adFlowMap.filter { it.key.startsWith(adId) }
        map.forEach {
            it.value?.value = load
        }
    }

    override fun loadPageAd(key: String, adId: String) {
        if (adId.isEmpty()) {
            Timber.e("monitorAd 广告ID为空")
            notifyPageAdState(adId, false)
        } else {
            val load = adIdLoadLock[adId]
            if (load == true) {
                Timber.e("monitorAd $key 加载广告ID一样，返回")
                return
            }
            if (key == AD_APP_LAUNCH) {
                adIdLoadLock[adId] = true
                RewardedAd.load(
                    context,
                    adId,
                    adManagerAdRequest,
                    object : RewardedAdLoadCallback() {
                        override fun onAdLoaded(ad: RewardedAd) {
                            super.onAdLoaded(ad)
                            adIdLoadLock[adId] = false
                            Timber.e("monitorAd key:$key 激励广告加载成功")
                            cacheRepository.monitorADEvent().value =
                                ADEvent.AD_LOAD_FINISH(currentKey, adId)
                            if (ad.fullScreenContentCallback == null) {
                                ad.fullScreenContentCallback =
                                    object : FullScreenContentCallback() {
                                        override fun onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent()
                                            cacheRepository.monitorADEvent().value =
                                                ADEvent.AD_DISMISS(currentKey, adId)
                                        }

                                        override fun onAdClicked() {
                                            super.onAdClicked()
                                            cacheRepository.monitorADEvent().value =
                                                ADEvent.AD_CLICK(currentKey, adId)
                                        }

                                        override fun onAdShowedFullScreenContent() {
                                            super.onAdShowedFullScreenContent()
                                            cacheRepository.monitorADEvent().value =
                                                ADEvent.AD_OPEN(currentKey, adId)
                                        }
                                    }
                            }
                            adMap[adId] = ad
                            notifyPageAdState(adId, true)
                        }

                        override fun onAdFailedToLoad(error: LoadAdError) {
                            super.onAdFailedToLoad(error)
                            adIdLoadLock[adId] = false
                            Timber.e("monitorAd key:$key adId:$adId 激励广告加载失败：$error")
                            adMap[adId] = null
                        }
                    })
            } else {
                adIdLoadLock[adId] = true
                InterstitialAd.load(
                    context,
                    adId,
                    adRequest,
                    object : InterstitialAdLoadCallback() {
                        override fun onAdLoaded(ad: InterstitialAd) {
                            super.onAdLoaded(ad)
                            adIdLoadLock[adId] = false
                            Timber.e("monitorAd key:$key 广告加载成功")
                            cacheRepository.monitorADEvent().value =
                                ADEvent.AD_LOAD_FINISH(currentKey, adId)
                            if (ad.fullScreenContentCallback == null) {
                                ad.fullScreenContentCallback =
                                    object : FullScreenContentCallback() {
                                        override fun onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent()
                                            cacheRepository.monitorADEvent().value =
                                                ADEvent.AD_DISMISS(currentKey, adId)
                                        }

                                        override fun onAdClicked() {
                                            super.onAdClicked()
                                            cacheRepository.monitorADEvent().value =
                                                ADEvent.AD_CLICK(currentKey, adId)
                                        }

                                        override fun onAdShowedFullScreenContent() {
                                            super.onAdShowedFullScreenContent()
                                            cacheRepository.monitorADEvent().value =
                                                ADEvent.AD_OPEN(currentKey, adId)
                                        }
                                    }
                            }
                            adMap[adId] = ad
                            notifyPageAdState(adId, true)
                        }

                        override fun onAdFailedToLoad(error: LoadAdError) {
                            super.onAdFailedToLoad(error)
                            adIdLoadLock[adId] = false
                            Timber.e("monitorAd key:$key adId:$adId 广告加载失败：$error")
                            adMap[adId] = null
                        }
                    })
            }
        }
    }

    override fun isPageAdLoad(adId: String): Boolean = adMap[adId] != null

    override suspend fun showPageAd(key: String, adId: String) {
        adMap[adId]?.let { ad ->
            activityLifecycleHandler.getCurrentActivity()?.let {
                currentKey = key
                if (ad is RewardedAd) {
                    ad.show(it, OnUserEarnedRewardListener { rewardItem ->
                        val rewardAmount = rewardItem.amount
                        val rewardType = rewardItem.type
                        Log.d("monitorad", "User earned the reward. $rewardAmount -- $rewardType")
                    })
                } else if (ad is InterstitialAd) {
                    ad.show(it)
                }
                adMap[adId] = null
                notifyPageAdState(adId, false)
            }
        }
    }

    override fun isEveryTimeShow(key: String): Boolean {
        return everyTimeMap[key] ?: false
    }

    override fun showEveryTime(key: String) {
        everyTimeMap[key] = true
    }

}