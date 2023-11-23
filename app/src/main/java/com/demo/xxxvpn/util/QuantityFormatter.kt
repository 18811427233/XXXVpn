package com.demo.xxxvpn.util

import android.content.Context
import com.demo.xxxvpn.R
import com.demo.xxxvpn.domain.usecase.tunnel.MonitorConnectStateUseCase.Companion.FETCH_STATISTICS_DELAY_INTERVAL
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject

class QuantityFormatter @Inject constructor(
    @ApplicationContext private val applicationContext: Context
) {

    private var lastUploadBytes: Long = 0
    private var lastDownloadBytes: Long = 0
    private var lastUseBytes: Long = 0

    fun reset() {
        lastUploadBytes = 0
        lastDownloadBytes = 0
    }

    /**
     * type 1 Download 2 Upload
     */
    fun formatBytes(type: Int, bytes: Long): String {
        val lastBytes = if (type == 1) lastUploadBytes else lastDownloadBytes
        val currentBytes = (bytes - lastBytes).toFloat() / FETCH_STATISTICS_DELAY_INTERVAL * 1000L
        val context = applicationContext
        if (type == 1) lastUploadBytes = bytes else lastDownloadBytes = bytes
        return when {
            currentBytes < 1024 -> context.getString(R.string.transfer_bytes, currentBytes)

            currentBytes < 1024 * 1024 -> context.getString(
                R.string.transfer_kibibytes,
                currentBytes / 1024.0
            )

            currentBytes < 1024 * 1024 * 1024 -> context.getString(
                R.string.transfer_mibibytes,
                currentBytes / (1024.0 * 1024.0)
            )

            currentBytes < 1024 * 1024 * 1024 * 1024L -> context.getString(
                R.string.transfer_gibibytes,
                currentBytes / (1024.0 * 1024.0 * 1024.0)
            )

            else -> context.getString(
                R.string.transfer_tibibytes,
                currentBytes / (1024.0 * 1024.0 * 1024.0) / 1024.0
            )
        }
    }

    /**
     * flow to unit
     */
    fun formatB(bytes: Long): String {

        val context = applicationContext
        return when {
            bytes < 1024 -> context.getString(R.string.unit_b, bytes)

            bytes < 1024 * 1024 -> context.getString(
                R.string.unit_kb,
                bytes / 1024.0
            )

            bytes < 1024 * 1024 * 1024 -> context.getString(
                R.string.unit_mb,
                bytes / (1024.0 * 1024.0)
            )

            bytes < 1024 * 1024 * 1024 * 1024L -> context.getString(
                R.string.unit_gb,
                bytes / (1024.0 * 1024.0 * 1024.0)
            )

            else -> context.getString(
                R.string.unit_tb,
                bytes / (1024.0 * 1024.0 * 1024.0) / 1024.0
            )
        }
    }

}