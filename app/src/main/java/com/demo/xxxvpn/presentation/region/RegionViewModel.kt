package com.demo.xxxvpn.presentation.region

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.xxxvpn.R
import com.demo.xxxvpn.domain.entity.network.Endpoint
import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.domain.repository.CacheRepository
import com.example.network.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegionViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val cacheRepository: CacheRepository,

    ) : ViewModel() {

    private val _uiState = MutableStateFlow(RegionUIState())
    val uiState = _uiState.asStateFlow()


    init {
        getServerList()
    }

    private fun getServerList() {
        viewModelScope.launch {
//            _uiState.update { state ->
//                state.copy(isLoading = true)
//            }
//            runCatching {
//                networkHelper.getServerList()
//            }.onSuccess { response ->
//
//                if (response.code == 200) {
//
//                    val regionList: MutableList<Region> = ArrayList()
//                    val d: MutableList<Endpoint> = ArrayList()
//                    val port: MutableList<Int> = ArrayList()
//                    port.add(51820)
//                    val endpoint = Endpoint("35.240.183.9", port);
//                    d.add(endpoint)
//                    var selectRegion: Region? = Region(d, "US", "Jacob")
//                    if (selectRegion != null) {
//                        regionList.add(selectRegion)
//                    }
//                    _uiState.update {
//                        it.copy(
//                            isLoading = false,
//                            regions = regionList,
//                            showError = false
//                        )
//                    }
//                } else {
//                    _uiState.update {
//                        it.copy(
//                            isLoading = false,
//                            showError = true,
//                            errorTitle = R.string.data_load_failed,
//                            errorSubTitle = R.string.data_load_failed_retry,
//                            errorBtnText = R.string.data_load_failed_refresh,
//                            errorClick = { getServerList() }
//                        )
//                    }
//                }
//            }.onFailure {
//                _uiState.update {
//                    it.copy(
//                        isLoading = false,
//                        showError = true,
//                        errorTitle = R.string.data_load_failed,
//                        errorSubTitle = R.string.data_load_failed_retry,
//                        errorBtnText = R.string.data_load_failed_refresh,
//                        errorClick = { getServerList() }
//                    )
//                }
//            }
        }
    }

    fun selectRegionClick(region: Region?) {
        viewModelScope.launch {
            cacheRepository.putRegion(region)
        }
    }
}