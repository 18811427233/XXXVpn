package com.demo.xxxvpn.domain.entity

/**
 * Tunnel statistics
 * @param isStale is tunnel connection stale
 * @param downloadBytes received bandwidth received in bytes
 * @param uploadBytes transmitted bandwidth in bytes
 */
data class TunnelStatistics(
    val isStale: Boolean,
    val downloadBytes: Long,
    val uploadBytes: Long
)