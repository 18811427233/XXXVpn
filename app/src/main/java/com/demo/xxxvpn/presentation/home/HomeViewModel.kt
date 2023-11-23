package com.demo.xxxvpn.presentation.home

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.alibaba.fastjson.JSON
import com.demo.xxxvpn.constant.Constant
import com.demo.xxxvpn.data.DataCenter
import com.demo.xxxvpn.data.UserFlowHelper
import com.demo.xxxvpn.data.repository.ActivityLifecycleHandler
import com.demo.xxxvpn.domain.ADEvent
import com.demo.xxxvpn.domain.entity.AccessRequest
import com.demo.xxxvpn.domain.entity.network.AD_APP_LAUNCH
import com.demo.xxxvpn.domain.entity.network.AD_BACK_TO_APP
import com.demo.xxxvpn.domain.entity.network.AD_SHOW_SPEED
import com.demo.xxxvpn.domain.entity.network.AD_TRY_TO_CONNECT
import com.demo.xxxvpn.domain.entity.network.Credential
import com.demo.xxxvpn.domain.entity.network.Endpoint
import com.demo.xxxvpn.domain.entity.network.LoginResponse
import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.domain.entity.tunnel.ConnectState
import com.demo.xxxvpn.domain.repository.CacheRepository
import com.demo.xxxvpn.domain.usecase.HadLoadADUseCase
import com.demo.xxxvpn.domain.usecase.IsAdLoadUseCase
import com.demo.xxxvpn.domain.usecase.MonitorCurrentConnectedTimestampUseCase
import com.demo.xxxvpn.domain.usecase.MonitorDeviceIdUseCase
import com.demo.xxxvpn.domain.usecase.ad.GetAdShowRuleCanShowUseCase
import com.demo.xxxvpn.domain.usecase.ad.MonitorAdEventUseCase
import com.demo.xxxvpn.domain.usecase.ad.MonitorAdUseCase
import com.demo.xxxvpn.domain.usecase.ad.ShowAdUseCase
import com.demo.xxxvpn.domain.usecase.ad.getADCountKey
import com.demo.xxxvpn.domain.usecase.ad.getADLastTimeKey
import com.demo.xxxvpn.domain.usecase.ad.getADTimeKey
import com.demo.xxxvpn.domain.usecase.tunnel.MonitorConnectStateUseCase
import com.demo.xxxvpn.presentation.AccessBehaviorEnum
import com.demo.xxxvpn.presentation.DotTargetEnum
import com.demo.xxxvpn.presentation.connect.OkHttpUrlConstant
import com.demo.xxxvpn.receiver.TimerReceiver
import com.demo.xxxvpn.service.VpnTunnelServiceWrapper
import com.demo.xxxvpn.util.DesUtils
import com.demo.xxxvpn.util.DeviceUtils
import com.demo.xxxvpn.util.QuantityFormatter
import com.demo.xxxvpn.util.SharedPreferencesUtils
import com.demo.xxxvpn.util.Utils
import com.example.network.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Calendar
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext private val applicationContext: Context,
    private val networkHelper: NetworkHelper,
    private val activityLifecycleHandler: ActivityLifecycleHandler,
    private val monitorConnectStateUseCase: MonitorConnectStateUseCase,
    private val monitorCurrentConnectedTimestampUseCase: MonitorCurrentConnectedTimestampUseCase,
    private val vpnTunnelServiceWrapper: VpnTunnelServiceWrapper,
    private val cacheRepository: CacheRepository,
    private val monitorDeviceIdUseCase: MonitorDeviceIdUseCase,
    private val quantityFormatter: QuantityFormatter,
    private val monitorAdUseCase: MonitorAdUseCase,
    private val monitorAdEventUseCase: MonitorAdEventUseCase,
    private val getAdShowRuleCanShowUseCase: GetAdShowRuleCanShowUseCase,
    private val showAdUseCase: ShowAdUseCase,
    private val hadLoadADUseCase: HadLoadADUseCase,
    private val isAdLoadUseCase: IsAdLoadUseCase

) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUIState())

    /**
     * UI State for [HomeScreen]
     * Flow of [HomeUIState]
     */
    val uiState = _uiState.asStateFlow()
    private var selectRegion: Region? = null
    private var credential: Credential? = null
    private var deviceId: String? = null
    private var connectStartTime: Long = 0
    private var retryPortIndex: Int = 0
    private var lastIsConnected: Boolean = false
    private var slice: Boolean = false
    private var timerManager: AlarmManager? = null
    private var timerIntent: PendingIntent? = null
    val showDialogLiveData = MutableLiveData<Int>()

    init {
        monitorCurrentConnectionTimestamp()
        monitorTunnelHealth()
        monitorSelectedRegion()
        monitorAdEvent()
        monitorAd()
        getDeviceId()
        userLogin()
        initData()

    }

    private fun updateBandwidthState(connectionHealth: ConnectState) {
        when (connectionHealth) {
            is ConnectState.Connected -> {

                UserFlowHelper.use(connectionHealth.statistics.downloadBytes + connectionHealth.statistics.uploadBytes)

                _uiState.update {
                    it.copy(
                        useFlow = quantityFormatter.formatB(
                            connectionHealth.statistics.downloadBytes + connectionHealth.statistics.uploadBytes

                        ), flow = quantityFormatter.formatB(
                            UserFlowHelper.getUserFlow()

                        )
                    )
                }
            }

            is ConnectState.Connecting, is ConnectState.Disconnected -> resetTrafficBandwidthState()
            else -> return
        }
    }

    private fun monitorCurrentConnectionTimestamp() = viewModelScope.launch {
        monitorCurrentConnectedTimestampUseCase().collectLatest { value ->
                _uiState.update { it.copy(lastRunningTimeStamp = value ?: 0) }
            }
    }

    private fun monitorTunnelHealth() = viewModelScope.launch {
        monitorConnectStateUseCase().catch {
                Timber.e(it, "exception")
            }.collectLatest { health ->
                if (health is ConnectState.Connected) {
                    slice = false
                }
                monitorShowSpeed(health)
                if (!slice) {
                    _uiState.update { it.copy(connectionHealth = health) }
                    if (health is ConnectState.Connecting) {
                        retryConnect()
                        UserFlowHelper.clearUseFlow()
                    }
                }
            }
    }

    private fun monitorSelectedRegion() {
        viewModelScope.launch {
            runCatching {
                cacheRepository.monitorRegion().collectLatest { region ->
                    if (selectRegion?.id != region?.id) {
                        _uiState.update {
                            it.copy(
                                selectRegion = region
                            )
                        }
                        val needReconnect = selectRegion != null
                        selectRegion = region
                        if (needReconnect) {
                            startConnectVPN()
                        }
                    } else {
                        getSelectRegion()
                    }
                }
            }.onFailure {
                Timber.e(it, message = "Fetch Server Location Fail")
            }
        }
    }

    private fun monitorShowSpeed(connectState: ConnectState) {
        viewModelScope.launch {
            runCatching {
                hadLoadADUseCase(AD_SHOW_SPEED)
            }.onSuccess { showAD ->
                if (connectState is ConnectState.Connected) {
                    _uiState.update {
                        it.copy(
                            showAD = showAD
                        )
                    }
                    if (!showAD) {
                        updateBandwidthState(connectState)
                    }
                }
            }.onFailure {
                Timber.e(it, message = "Fetch Server Location Fail")
            }
        }
    }

    private fun getSelectRegion() {
        viewModelScope.launch {

            val d: MutableList<Endpoint> = ArrayList()
            val port: MutableList<Int> = ArrayList()
            port.add(51820)
            val endpoint = Endpoint("35.240.183.9", port);
            d.add(endpoint)
            selectRegion = Region(d, "US", "Jacob")

            cacheRepository.putRegion(selectRegion)
            _uiState.update { state ->
                state.copy(
                    selectRegion = selectRegion
                )
            }
//            runCatching {
//                networkHelper.getServerList()
//            }.onSuccess {
//                if (it.data.isNotEmpty()) {
////                    selectRegion = it.data[Random().nextInt(it.data.size)]
//
//                }
//            }.onFailure {
//                Timber.e(it, "getSelectRegion")
//            }
        }
    }

    private fun getDeviceId() {

        viewModelScope.launch {
            runCatching { monitorDeviceIdUseCase() }.onSuccess {
                    deviceId = it
                    // 获取系统剪贴板管理器
//                    val clipboardManager = applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//                    // 将文本复制到剪贴板
//                    val textToCopy = deviceId
//                    val clipData = ClipData.newPlainText("text label", textToCopy)
//                    clipboardManager.setPrimaryClip(clipData)
//                    Toast.makeText(applicationContext, "adId已经复制到粘贴板中", Toast.LENGTH_SHORT).show()
                    if (deviceId.isNullOrBlank().not()) {
                        getCredential()
//                        getADConfig()
                        getUserInfo()
                    }
                }.onFailure { Timber.e(it, "getDeviceId") }
        }
    }

    private fun initData() {

        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Timber.e("-----3333-----")
                if (intent != null) {
                    when (intent.action) {
                        "rewardCdUpdate" -> {

                            Timber.e("-----4444-----")

                            viewModelScope.launch {

                                runCatching {

                                    val headerMap: MutableMap<String, String> = java.util.HashMap()
                                    headerMap["unionkey"] =
                                        SharedPreferencesUtils.getInstance(applicationContext)
                                            .getString(Constant.SP_KEY_USER_TOKEN)

                                    networkHelper.getRewardedCd(headerMap)

                                }.onSuccess { response ->
                                    if (response.status == 200) {

                                        val loginResponse: LoginResponse = response.data

                                        Timber.e(
                                            "getRewardedCd:::" + JSON.toJSONString(
                                                loginResponse
                                            )
                                        )

                                        if (loginResponse.getCdAdHourList().isNotEmpty()) {
                                            var rewardCount = -1
                                            for (cdInfoVO in loginResponse.getCdAdHourList()) {
                                                val used =
                                                    if (cdInfoVO.getRewardUsed() == null) 0 else cdInfoVO.getRewardUsed()
                                                if (rewardCount == -1 || rewardCount > cdInfoVO.getRewardTotal() - used) {
                                                    rewardCount = cdInfoVO.getRewardTotal() - used
                                                }
                                            }
                                            DataCenter.getInstance(applicationContext).rewardCount =
                                                rewardCount
                                        } else {
                                            val used =
                                                if (loginResponse.cdAdDay.rewardUsed == null) 0 else loginResponse.cdAdDay.rewardUsed
                                            DataCenter.getInstance(applicationContext).rewardCount =
                                                loginResponse.cdAdDay.rewardTotal - used
                                        }

                                        _uiState.update {
                                            it.copy(
                                                rewardCount = DataCenter.getInstance(
                                                    applicationContext
                                                ).rewardCount,
                                            )

                                        }

                                    }
                                }.onFailure {
                                    Timber.e(it, "getUserInfo")
                                }
                            }

                            setTimerManager()
                        }
                    }
                }
            }
        }
        timerManager = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent1 = Intent(applicationContext, TimerReceiver::class.java)
        intent1.action = "rewardCd"
        timerIntent = PendingIntent.getBroadcast(
            applicationContext, Utils.random(5), intent1, PendingIntent.FLAG_IMMUTABLE
        )

        val filter = IntentFilter()
        filter.addAction("rewardCdUpdate")
        LocalBroadcastManager.getInstance(applicationContext).registerReceiver(receiver, filter)

        setTimerManager()

    }

    private fun setTimerManager() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && !timerManager?.canScheduleExactAlarms()!!) {
            return
        }
        timerIntent?.let {
            timerManager?.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5 * 60 * 1000, it
            )
        }
    }

    private fun showDialog(param: Int) {
        showDialogLiveData.value = param
    }

    private fun userLogin() {

        viewModelScope.launch {

            runCatching {

                val random: String? = DeviceUtils.getRandomCode(12)
                val timestamp = System.currentTimeMillis().toString()

                val uniqueKey = random + DeviceUtils.getDeviceId(applicationContext) + timestamp

                val desUtils = DesUtils(OkHttpUrlConstant.VER2_VALUE)
                val encryptUniqueKey: String = desUtils.encrypt(uniqueKey)

                val softwareInfo: String = Utils.getVersionName(applicationContext)
                val hardwareInfo: String =
                    DeviceUtils.getManufacturer() + " " + DeviceUtils.getModel() + " " + DeviceUtils.getSDKVersionName()

                val headerMap: MutableMap<String, String> = HashMap()
                headerMap["ver"] = OkHttpUrlConstant.VER2_KEY

                networkHelper.userLogin(
                    headerMap,
                    encryptUniqueKey,
                    random,
                    timestamp,
                    applicationContext.packageName,
                    hardwareInfo,
                    softwareInfo
                )

            }.onSuccess { response ->

                if (response.status == 200) {

                    val loginResponse: LoginResponse = response.data

                    if (loginResponse.isForbid == 4) {
//                        showDialog(1)
                        System.exit(0)
                        return@launch
                    }
                    if (loginResponse.token == null) {
//                        showDialog(2)
                        System.exit(0)
                        return@launch
                    }

                    SharedPreferencesUtils.getInstance(applicationContext)
                        .putString(Constant.SP_KEY_USER_TOKEN, loginResponse.token)

                    if (loginResponse.adRewardFlows != null) {
                        DataCenter.getInstance(applicationContext).rewardFlows =
                            (loginResponse.adRewardFlows * 1024 * 1024).toLong()
                    }


                    UserFlowHelper.init(
                        (loginResponse.userFlows * 1024 * 1024).toLong()
                    )

                    DataCenter.getInstance(applicationContext).rewardCdTimerTimestamp =
                        System.currentTimeMillis()

                    val used1 =
                        if (loginResponse.cdAdDay.rewardUsed == null) 0 else loginResponse.cdAdDay.rewardUsed
                    if (loginResponse.cdAdHourList.isNotEmpty()) {
                        var rewardCount = -1
                        for (cdInfoVO in loginResponse.cdAdHourList) {
                            val used = if (cdInfoVO.rewardUsed == null) 0 else cdInfoVO.rewardUsed
                            if (rewardCount == -1 || rewardCount > cdInfoVO.rewardTotal - used) {
                                rewardCount = cdInfoVO.rewardTotal - used
                            }
                        }
                        DataCenter.getInstance(applicationContext).rewardCount = rewardCount
                    } else {
                        DataCenter.getInstance(applicationContext).rewardCount =
                            loginResponse.cdAdDay.rewardTotal - used1
                    }

                    DataCenter.getInstance(applicationContext).rewardName = loginResponse.adTextNew

                }

                _uiState.update {

                    it.copy(

                        flow = quantityFormatter.formatB(UserFlowHelper.getUserFlow()),
                        rewardCount = DataCenter.getInstance(applicationContext).rewardCount,
                        rewardFlow = quantityFormatter.formatB(
                            DataCenter.getInstance(
                                applicationContext
                            ).rewardFlows
                        ),
                        rewardName = DataCenter.getInstance(applicationContext).rewardName
                    )

                }
            }.onFailure {
                Timber.e(it, "UserLogin_Error")
            }
        }
    }

    private fun monitorAdEvent() {
        viewModelScope.launch {
            monitorAdEventUseCase().collectLatest {
                Timber.e("monitorAd $it")
                if (it is ADEvent.AD_DISMISS) {
                    if (it.key == AD_TRY_TO_CONNECT) {
                        startConnectVPN()
                    } else if (it.key == AD_APP_LAUNCH) {
                        showAdToday()
                    } else {
                        if (lastIsConnected && slice) {
                            Timber.e("autoConnect AD_LOAD_FINISH 重连开始")
                            if (isAdLoadUseCase(it.adId)) {
                                startConnectVPN(true)
                            } else {
                                resetConnectFailEvent()
                            }
                        }
                    }
                } else if (it is ADEvent.AD_BACK_TO_TOP) {
                    showAdUseCase(AD_BACK_TO_APP)
                }
            }
        }
        viewModelScope.launch {
            monitorAdUseCase(AD_APP_LAUNCH) {
                slice = true
                resetToNormalConnection(true)
            }
        }
    }

    private fun showAdToday() {
        viewModelScope.launch {
            val adKey = AD_APP_LAUNCH
            val count = cacheRepository.monitorInt(adKey.getADCountKey()).first() ?: 0
            cacheRepository.putInt(adKey.getADCountKey(), count + 1)
            cacheRepository.putLong(
                adKey.getADLastTimeKey(), Calendar.getInstance().timeInMillis
            )
            if (count == 0) {
                cacheRepository.putLong(
                    adKey.getADTimeKey(), Calendar.getInstance().timeInMillis
                )
            }
            _uiState.update { state ->
                state.copy(showADDialog = false)
            }
        }
    }

    private fun monitorAd() {
        viewModelScope.launch {
            val needMonitor = cacheRepository.monitorADConfig(AD_APP_LAUNCH).first() == null
            if (needMonitor.not()) {
                Timber.e("monitorad monitorAd start")
                viewModelScope.launch {
                    monitorAdUseCase(AD_TRY_TO_CONNECT) {
                        slice = true
                        resetToNormalConnection(true)
                    }
                }
                viewModelScope.launch {
                    monitorAdUseCase(AD_SHOW_SPEED) {
                        slice = true
                        resetToNormalConnection(true)
                    }
                }
                viewModelScope.launch {
                    monitorAdUseCase(AD_BACK_TO_APP) {
                        slice = true
                        resetToNormalConnection(true)
                    }
                }
                loadAdDialog()
                viewModelScope.launch {
                    monitorAdUseCase(AD_APP_LAUNCH) {
                        slice = true
                        resetToNormalConnection(true)
                    }
                }
            }
        }
    }

    private fun loadAdDialog(userHandle: Boolean = false) {
        viewModelScope.launch {
            val canShowUseCase = getAdShowRuleCanShowUseCase(AD_APP_LAUNCH, false)
            _uiState.update {
                it.copy(showADDialog = canShowUseCase)
            }
            if (!canShowUseCase && userHandle) {
                tryToConnect()
            }
        }
    }

    private fun getUserInfo() {
//        viewModelScope.launch {
//            runCatching {
//                networkHelper.getUserInfo(deviceId)
//            }.onSuccess { response ->
//                if (response.code == 200) {
//                    response.data.let {
//                        cacheRepository.putUser(it)
//                    }
//                }
//            }.onFailure {
//                Timber.e(it, "getUserInfo")
//            }
//        }
    }

    private fun getADConfig() {
        viewModelScope.launch {

//            runCatching {
//                networkHelper.getAdConfig(deviceId, BuildConfig.VERSION_NAME)
//            }.onSuccess { response ->
//                if (response.code == 200) {
//                    response.data.let {
//                        val defaultConfig = it.filter { ad -> ad.position == AD_DEFAULT_POSITION }
//                        it.forEach { ad ->
//                            ad?.adId ?: "ca-app-pub-3940256099942544/5224354917"
//                            if (ad.frequency.isNullOrBlank()) {
//                                if (defaultConfig.isNotEmpty()) {
//                                    cacheRepository.putADConfig(
//                                        ad.position,
//                                        "Null".formatFrequency(ad.adId)
//                                    )
//                                } else {
//                                    cacheRepository.putADConfig(ad.position, null)
//                                }
//                            } else {
//                                cacheRepository.putADConfig(
//                                    ad.position,
//                                    ad.frequency?.formatFrequency(ad.adId)
//                                )
//                            }
//                        }
//                    }
//                    monitorAd()
//                }
//            }.onFailure {
//                Timber.e(it, "getUserInfo")
//            }
        }
    }

    fun toggleTunnel() {

        viewModelScope.launch {
            if (selectRegion == null) {
                _uiState.update {
                    it.copy(notifySelectRegionEvent = triggered)
                }
                return@launch
            }
//            loadAdDialog(true)
            tryToConnect()
        }
    }

    private fun tryToConnect() {
        viewModelScope.launch {
            if (uiState.value.connectionHealth is ConnectState.Disconnected) {
                val showAd = showAdUseCase(AD_TRY_TO_CONNECT)
                if (!showAd) {
                    startConnectVPN()
                }
            } else {
                resetToNormalConnection()
            }
        }
    }

    private fun startConnectVPN(slice: Boolean = false) {

        viewModelScope.launch {
            _uiState.update {
                it.copy(connectionHealth = ConnectState.Connecting)
            }
            if (credential == null) {

                getCredential()

                return@launch
            }

            quantityFormatter.reset()
            connectStartTime = Calendar.getInstance().timeInMillis
            val regionPortCount = selectRegion?.endpointList?.get(0)?.portList?.size ?: 0

            if (retryPortIndex < regionPortCount) {
                lastIsConnected = true

                vpnTunnelServiceWrapper.startTunnelService(retryPortIndex, slice)
            } else {
                resetToNormalConnection()
            }
        }
    }

    private suspend fun getCredential() {


        viewModelScope.launch {

            credential = Credential(
                "1.1.1.1",
                "10.10.0.2/32",
                "fd86:ea04:1111::2/128",
                "TMdOcWti6LzUz9gyZ9rvxW3/Nj8OtrFrHX0BXa5qzD0=",
                "",
                "6KDCaOIghGpUzTX3bX5LRHVw9VU05O+WDhK0VFKKNXo=",
                "DbbIzSBo11b/fPG0kXEf7/1+ZKfpLzYUkVTWYvLgsUQ="
            )

            cacheRepository.putCredential(credential)

//            runCatching {
//            networkHelper.getCredential(deviceId)
//            }.onSuccess { response ->
//                if (response.code == 200) {
//                    credential = response.data
//                    cacheRepository.putCredential(response.data)
//
//                } else {
//                    resetToNormalConnection()
//                }
//            }.onFailure {
//                Timber.e(it, "getCredential")
//                if (BuildConfig.DEBUG) {
//                    Toast.makeText(
//                        activityLifecycleHandler.getCurrentActivity(),
//                        "获取credential失败：$it",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//                resetToNormalConnection()
//            }
        }

    }

    fun resetToNormalConnection(slice: Boolean = false) {
        _uiState.update {
            it.copy(connectionHealth = ConnectState.Disconnected)
        }
        connectStartTime = 0
        retryPortIndex = 0
        if (!slice) {
            lastIsConnected = false
        }
        vpnTunnelServiceWrapper.stopTunnelService(slice)
    }

    private fun resetTrafficBandwidthState() = viewModelScope.launch {
        _uiState.update { it.copy(uploadSpeed = "", downloadSpeed = "") }
    }

    fun resetNotifySelectRegionEvent() = viewModelScope.launch {
        _uiState.update { it.copy(notifySelectRegionEvent = consumed) }
    }

    private fun retryConnect() {
        viewModelScope.launch {
            if (Calendar.getInstance().timeInMillis - connectStartTime > CONNECT_TIMEOUT_DURATION) {
                retryPortIndex++
                val regionPortCount = selectRegion?.endpointList?.get(0)?.portList?.size ?: 0
                if (retryPortIndex >= regionPortCount || retryPortIndex >= MAX_RETRY_PORT_COUNT) {
//                    if (BuildConfig.DEBUG) {
//                        Toast.makeText(
//                            activityLifecycleHandler.getCurrentActivity(),
//                            "重试机制结束",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
                    resetToNormalConnection()
                    _uiState.update {
                        it.copy(connectFailEvent = triggered)
                    }
                } else {
//                    if (BuildConfig.DEBUG) {
//                        Toast.makeText(
//                            activityLifecycleHandler.getCurrentActivity(),
//                            "重试机制开始",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
                    startConnectVPN()
                }
            }
        }
    }

    fun resetConnectFailEvent() {
        _uiState.update {
            it.copy(connectFailEvent = consumed)
        }
    }

    fun showSpeedAd() {
        viewModelScope.launch {
            runCatching {
                showAdUseCase(AD_SHOW_SPEED)
            }.onFailure {
                Timber.e(it, "loadPageAd")
            }
        }
    }

    fun onClickPointAccess() {
        viewModelScope.launch {
            runCatching {

                val dotFlag = "point_access" + Utils.random(6) + System.currentTimeMillis()
                val headerMap: MutableMap<String, String> = java.util.HashMap()
                headerMap["unionkey"] = SharedPreferencesUtils.getInstance(applicationContext)
                    .getString(Constant.SP_KEY_USER_TOKEN)

                networkHelper.pointAccess(
                    headerMap, AccessRequest(
                        DotTargetEnum.CLICK.type,
                        null,
                        AccessBehaviorEnum.VIEW.type,
                        dotFlag,
                        null,
                        "reward_click"
                    )
                )

            }.onSuccess { response ->

                if (response.status == 200) {

                    DataCenter.getInstance(applicationContext).rewardCount =
                        DataCenter.getInstance(applicationContext).rewardCount - 1

                }

                _uiState.update {
                    it.copy(
                        rewardCount = DataCenter.getInstance(applicationContext).rewardCount
                    )

                }
            }.onFailure {
                Timber.e(it, "UserLogin_Error")
            }
        }
    }

    fun onDismissADDialog() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(showADDialog = false)
            }
        }
    }

    fun onClickWatchAD() {
        viewModelScope.launch {
            showAdUseCase(AD_APP_LAUNCH)
        }
    }

    companion object {
        const val KEY_RECONNECT_FLAG = "key_reconnect_flag"
        const val CONNECT_TIMEOUT_DURATION = 10_000
        const val MAX_RETRY_PORT_COUNT = 3
    }

}
