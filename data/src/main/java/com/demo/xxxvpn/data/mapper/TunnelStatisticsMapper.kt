package com.demo.xxxvpn.data.mapper

import com.wireguard.android.backend.Statistics
import com.demo.xxxvpn.domain.entity.TunnelStatistics
import timber.log.Timber
import javax.inject.Inject

class TunnelStatisticsMapper @Inject constructor() {
    operator fun invoke(statistics: Statistics) = TunnelStatistics(
        isStale = statistics.isStale,
        downloadBytes = statistics.totalRx(),
        uploadBytes = statistics.totalTx()

    )

}