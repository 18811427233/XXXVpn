package com.demo.xxxvpn.domain.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class NetWorkResponse<T>(
    val status: Int,
    val msg: String,
    val data: T,
)





