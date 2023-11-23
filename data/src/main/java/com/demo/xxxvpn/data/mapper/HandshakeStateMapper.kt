package com.demo.xxxvpn.data.mapper

import com.wireguard.android.backend.Statistics
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import com.demo.xxxvpn.domain.entity.HandshakeState
import com.demo.xxxvpn.domain.qualifiers.IoDispatcher
import java.util.Calendar
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HandshakeStateMapper @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(peerStats: Statistics.PeerStats?): HandshakeState =
        withContext(ioDispatcher) {
            val latestHandshakeInMillis = peerStats?.latestHandshakeEpochMillis ?: 0L

            when {
                peerStats == null || latestHandshakeInMillis == 0L -> HandshakeState.NEVER
                diffInSeconds(latestHandshakeInMillis) >= HandshakeState.WEAK_TIME_LIMIT_SEC -> HandshakeState.WEAK
                else -> HandshakeState.STRONG
            }
        }

    private fun diffInSeconds(time: Long): Long =
        TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().timeInMillis - time)
}