package com.demo.xxxvpn.domain.repository

import kotlinx.coroutines.flow.Flow
import com.demo.xxxvpn.domain.entity.NetworkState

interface AndroidSystemRepository {
    /**
     * Monitor network connectivity to check whether device is connected to the internet
     *
     * @see NetworkState
     */
    val getNetworkState: Flow<NetworkState>

    /**
     * Copy text to primary clipboard
     *
     * @param label the clipboard label as [String]
     * @param text the text to copy to clipboard as [String]
     */
    suspend fun copyTextToClipboard(label: String, text: String)


    suspend fun doesFileExist(path: String?): Boolean
}