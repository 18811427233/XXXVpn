package com.example.network

import com.demo.xxxvpn.domain.entity.ADConfigRequest
import com.demo.xxxvpn.domain.entity.AccessRequest
import com.demo.xxxvpn.domain.entity.DeviceIdRequest
import com.demo.xxxvpn.domain.entity.LoginRequest
import com.demo.xxxvpn.domain.entity.NetWorkResponse
import com.demo.xxxvpn.domain.entity.network.ADConfig
import com.demo.xxxvpn.domain.entity.network.Credential
import com.demo.xxxvpn.domain.entity.network.LoginResponse
import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.domain.entity.network.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import java.util.Objects

interface NiaNetworkApi {

    @POST(API + "getServerList")
    suspend fun getServerList(): NetWorkResponse<List<Region>>

    @POST(API + "getCredential")
    suspend fun getCredential(@Body request: DeviceIdRequest): NetWorkResponse<Credential>

    @POST(API + "getUserInfo")
    suspend fun getUserInfo(@Body request: DeviceIdRequest): NetWorkResponse<User>

    @POST(API + "getAdConfig")
    suspend fun getAdConfig(@Body request: ADConfigRequest): NetWorkResponse<List<ADConfig>>

    @POST(API_1 + "point/access")
    suspend fun pointAccess(@HeaderMap header: Map<String, String>,@Body request: AccessRequest): NetWorkResponse<Any>

    @GET(API_1 + "user/flows")
    suspend fun userFlows( @HeaderMap header: Map<String, String>): NetWorkResponse<LoginResponse>

    @POST(API_1 + "user/login")
    suspend fun userLogin(
        @HeaderMap header: Map<String, String>,
        @Body request: LoginRequest
    ): NetWorkResponse<LoginResponse>


    companion object {
        const val API = "/api/v1/"
        const val API_1 = "/v2/api/mirror/"
    }
}