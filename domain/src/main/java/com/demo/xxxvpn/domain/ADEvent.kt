package com.demo.xxxvpn.domain

sealed interface ADEvent {

    data object INIT : ADEvent

    data object AD_BACK_TO_TOP : ADEvent

    data class AD_LOAD_FINISH(val key: String, val adId: String) : ADEvent

    data class AD_DISMISS(val key: String, val adId: String) : ADEvent

    data class AD_OPEN(val key: String, val adId: String) : ADEvent

    data class AD_CLICK(val key: String, val adId: String) : ADEvent


}