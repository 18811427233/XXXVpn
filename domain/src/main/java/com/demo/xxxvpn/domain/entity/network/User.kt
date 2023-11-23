package com.demo.xxxvpn.domain.entity.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class User(
    val deviceId: String,
    val id: String?,
    val valueLevel: Int
)