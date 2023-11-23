package com.demo.xxxvpn.domain.repository

import com.demo.xxxvpn.domain.ADEvent
import com.demo.xxxvpn.domain.entity.network.ADShowRule
import com.demo.xxxvpn.domain.entity.network.Credential
import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.domain.entity.network.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface CacheRepository {

    fun monitorADEvent(): MutableStateFlow<ADEvent>

    suspend fun putUser(user: User?)

    suspend fun putADConfig(key: String, adShowRule: ADShowRule?)

    suspend fun putRegion(region: Region?)

    suspend fun putCredential(credential: Credential?)

    suspend fun monitorUser(): Flow<User?>

    suspend fun monitorADConfig(key: String): Flow<ADShowRule?>

    suspend fun monitorRegion(): Flow<Region?>

    suspend fun monitorCredential(): Flow<Credential?>

    suspend fun putLong(key: String, data: Long)

    suspend fun monitorLong(key: String): Flow<Long?>

    suspend fun putInt(key: String, data: Int)

    suspend fun monitorInt(key: String): Flow<Int?>

    suspend fun putString(key: String, data: String)

    suspend fun monitorString(key: String): Flow<String?>

    suspend fun putBoolean(key: String, data: Boolean)

    suspend fun monitorBoolean(key: String, defaultValue: Boolean): Flow<Boolean>

    companion object {
        const val CACHE_KEY_USER = "key_user"
        const val CACHE_KEY_REGION = "key_region"
        const val CACHE_KEY_BILL = "key_bill"
        const val CACHE_KEY_CREDENTIAL = "key_credential"
        const val CACHE_KEY_LAST_CONNECT_TIME = "key_last_connect_time"
    }
}