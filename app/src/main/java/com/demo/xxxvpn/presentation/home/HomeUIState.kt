package com.demo.xxxvpn.presentation.home

import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed
import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.domain.entity.tunnel.ConnectState

data class HomeUIState(
    val isConnectedToNetwork: Boolean = true,
    val showAD: Boolean = true,
    val connectionHealth: ConnectState = ConnectState.Disconnected,
    val downloadSpeed: String = "",
    val uploadSpeed: String = "",
    val useFlow: String = "",
    val rewardFlow: String = "",
    val rewardName: String = "",
    val rewardCount: Int = 0,
    val flow: String = "",
    val lastRunningTimeStamp: Long = 0,
    val selectRegion: Region? = null,
    val notifySelectRegionEvent: StateEvent = consumed,
    val connectFailEvent: StateEvent = consumed,
    val showADDialog: Boolean = false
)