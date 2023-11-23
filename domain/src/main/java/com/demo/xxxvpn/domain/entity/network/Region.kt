package com.demo.xxxvpn.domain.entity.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class Region(
    val endpointList: List<Endpoint>,
    val id: String,
    val name: String
)

@JsonClass(generateAdapter = false)
data class Endpoint(
    val address: String,
    val portList: List<Int>
)