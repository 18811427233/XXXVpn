package com.demo.xxxvpn.domain.entity.network

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = false)
data class Credential(
    val dns: String,
    val ipV4: String,
    val ipV6: String,
    val peerPublicKey: String,
    val preSharedKey: String,
    val privateKey: String,
    val publicKey: String


)
