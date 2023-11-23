package com.demo.xxxvpn.presentation.region

import com.demo.xxxvpn.domain.entity.network.Region

data class RegionUIState(
    val isLoading: Boolean = false,
    val regions: List<Region>? = null,
    val showError: Boolean = false,
    val errorTitle: Int = 0,
    val errorSubTitle: Int = 0,
    val errorBtnText: Int = 0,
    val errorClick: () -> Unit = {}
)