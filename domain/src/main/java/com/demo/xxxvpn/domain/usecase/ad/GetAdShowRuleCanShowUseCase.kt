package com.demo.xxxvpn.domain.usecase.ad

import com.demo.xxxvpn.domain.entity.network.AD_DEFAULT_POSITION
import com.demo.xxxvpn.domain.repository.ADRepository
import com.demo.xxxvpn.domain.repository.CacheRepository
import kotlinx.coroutines.flow.first
import java.util.Calendar
import javax.inject.Inject

class GetAdShowRuleCanShowUseCase @Inject constructor(
    private val cacheRepository: CacheRepository,
    private val adRepository: ADRepository,
) {

    suspend operator fun invoke(key: String, preLoad: Boolean): Boolean {
        var rule = cacheRepository.monitorADConfig(key).first()
        if (rule?.showCount == 0) {
            println("monitorAd $key 显示次数为0")
            return false
        }
        val ruleKey = if (rule?.showCount == -1) {
            rule = cacheRepository.monitorADConfig(AD_DEFAULT_POSITION).first()
            AD_DEFAULT_POSITION
        } else {
            key
        }
        if (rule != null) {
            if (rule.frequencyDay == 0) {
                if (adRepository.isEveryTimeShow(ruleKey)) {
                    println("monitorAd $key 每次打开已触发过")
                    return false
                }
            }
            val lastFrequencyTime =
                cacheRepository.monitorLong(ruleKey.getADTimeKey()).first() ?: 0L
            val lastShowCount =
                //每次，或者周期时间变了
                if (rule.frequencyDay == 0 ||
                    (lastFrequencyTime != 0L && isNotToday(lastFrequencyTime, rule.frequencyDay))
                ) {
                    println("monitorAd $key 不是今天 ${rule.frequencyDay == 0}")
                    cacheRepository.putInt(ruleKey.getADCountKey(), 0)
                    0
                } else {
                    println("monitorAd $key 是今天")
                    cacheRepository.monitorInt(ruleKey.getADCountKey()).first() ?: 0
                }
            val lastShowTime = cacheRepository.monitorLong(ruleKey.getADLastTimeKey()).first() ?: 0L
            //没有次数超限，而且离上次限时间超过了冷却时间
            println("monitorAd $key 次数超限：$lastShowCount=${rule.showCount}=${lastShowCount < rule.showCount}")
            println("monitorAd $key 时间限制：${Calendar.getInstance().timeInMillis - lastShowTime}=${rule.cdTime * 60 * 1000L}=${Calendar.getInstance().timeInMillis - lastShowTime >= rule.cdTime * 60 * 1000L}")
            if (lastShowCount < rule.showCount) {
                if (preLoad) {
                    //加载不需要判断时间，直接加载
                    return true
                } else {
                    if (Calendar.getInstance().timeInMillis - lastShowTime >= rule.cdTime * 60 * 1000L) {
                        //显示需要判断时间
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun isNotToday(timestamp: Long, cdDay: Int): Boolean {
        val calendar = Calendar.getInstance()
        val today = calendar.get(Calendar.DAY_OF_YEAR)

        calendar.timeInMillis = timestamp
        val day = calendar.get(Calendar.DAY_OF_YEAR)

        return today - day >= cdDay
    }

}

fun String.getADTimeKey(): String {
    return "$this-FirstTime"
}

fun String.getADLastTimeKey(): String {
    return "$this-LastTime"
}

fun String.getADCountKey(): String {
    return "$this-Count"
}