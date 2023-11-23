package com.example.network

import com.demo.xxxvpn.domain.entity.ADConfigRequest
import com.demo.xxxvpn.domain.entity.AccessRequest
import com.demo.xxxvpn.domain.entity.DeviceIdRequest
import com.demo.xxxvpn.domain.entity.LoginRequest
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHelper @Inject constructor(
    private val retrofit: Retrofit,
) {

    private val networkApi = retrofit
        .create(NiaNetworkApi::class.java)

    suspend fun getServerList() = networkApi.getServerList()

    suspend fun getCredential(deviceId: String?) =
        networkApi.getCredential(DeviceIdRequest(deviceId))

//    suspend fun getUserInfo(deviceId: String?) = networkApi.getUserInfo(DeviceIdRequest(deviceId))

    suspend fun getAdConfig(deviceId: String?, appVersion: String?) =
        networkApi.getAdConfig(ADConfigRequest(deviceId, appVersion))

    suspend fun getRewardedCd(header: Map<String, String>) =
        networkApi.userFlows(header)

    suspend fun pointAccess(
        header: Map<String, String>, accessRequest: AccessRequest
    ) =
        networkApi.pointAccess(
            header, accessRequest
        )

    suspend fun userLogin(
        header: Map<String, String>,
        uuidFlag: String?,
        number: String?,
        times: String?,
        prefix: String?,
        versionName: String?,
        versionNumber: String?
    ) =
        networkApi.userLogin(
            header,
            LoginRequest(uuidFlag, number, times, prefix, versionName, versionNumber)
        )

}