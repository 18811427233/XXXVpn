package com.demo.xxxvpn.domain.repository

import kotlinx.coroutines.flow.MutableStateFlow

interface ADRepository {

    fun init()

    fun monitorPageAd(key: String, adId: String): MutableStateFlow<Boolean>

    fun notifyPageAdState(adId: String, load: Boolean)

    fun loadPageAd(key: String, adId: String)

    fun isPageAdLoad(adId: String): Boolean

    suspend fun showPageAd(key: String, adId: String)

    fun isEveryTimeShow(key: String): Boolean

    fun showEveryTime(key: String)

}