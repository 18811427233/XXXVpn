package com.demo.xxxvpn.domain.entity.network

import com.squareup.moshi.JsonClass

const val AD_DEFAULT_POSITION = "default"
const val AD_APP_LAUNCH = "AppLaunch"
const val AD_TRY_TO_CONNECT = "TryToConnect"
const val AD_BACK_TO_APP = "BackToApp"
const val AD_SPEED_TEST = "SpeedTest"
const val AD_SHOW_SPEED = "ShowSpeed"

@JsonClass(generateAdapter = false)
data class ADConfig(
    val frequency: String?,
    val position: String,
    val adId: String
)

data class ADShowRule(
    val showCount: Int = 0,
    val frequencyDay: Int = 0,
    val cdTime: Int = 0,
    val adId: String
)

fun String.formatFrequency(adId: String): ADShowRule {
    return if ("Everytime" == this) {
        ADShowRule(1, 0, -1, adId)
    } else if ("Once" == this) {
        ADShowRule(1, 999999, -1, adId)
    } else if ("Never" == this) {
        ADShowRule(0, -1, -1, adId)
    } else if ("Null" == this) {
        ADShowRule(-1, -1, -1, adId)
    } else {
        val list = this.split("/").map { it.toInt() }
        ADShowRule(list[0], list[1], list[2], adId)
    }
}