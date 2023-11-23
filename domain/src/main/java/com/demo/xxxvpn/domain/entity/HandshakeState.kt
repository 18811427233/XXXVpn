package com.demo.xxxvpn.domain.entity

/**
 * VPN tunnel connection peer handshake state
 */
enum class HandshakeState {
    STRONG,
    WEAK,
    NEVER;

    companion object {
        const val WEAK_TIME_LIMIT_SEC = 180
    }
}