package com.demo.xxxvpn.data.repository

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.demo.xxxvpn.data.gateway.PreferencesGateway
import com.demo.xxxvpn.domain.ADEvent
import com.demo.xxxvpn.domain.entity.network.ADShowRule
import com.demo.xxxvpn.domain.entity.network.Credential
import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.domain.entity.network.User
import com.demo.xxxvpn.domain.qualifiers.IoDispatcher
import com.demo.xxxvpn.domain.repository.CacheRepository
import com.demo.xxxvpn.domain.repository.CacheRepository.Companion.CACHE_KEY_BILL
import com.demo.xxxvpn.domain.repository.CacheRepository.Companion.CACHE_KEY_CREDENTIAL
import com.demo.xxxvpn.domain.repository.CacheRepository.Companion.CACHE_KEY_REGION
import com.demo.xxxvpn.domain.repository.CacheRepository.Companion.CACHE_KEY_USER
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val preferencesGateway: PreferencesGateway,
    private val moshi: Moshi
) : CacheRepository {

    private val adEventFlow = MutableStateFlow<ADEvent>(ADEvent.INIT)

    override fun monitorADEvent(): MutableStateFlow<ADEvent> = adEventFlow

    override suspend fun putUser(user: User?) {
        withContext(ioDispatcher) {
            preferencesGateway.putString(
                CACHE_KEY_USER,
                moshi.adapter(User::class.java).toJson(user)
            )
        }
    }

    override suspend fun putADConfig(key: String, adShowRule: ADShowRule?) {
        withContext(ioDispatcher) {
            preferencesGateway.putString(
                key,
                moshi.adapter(ADShowRule::class.java).toJson(adShowRule)
            )
        }
    }

    override suspend fun putRegion(region: Region?) {
        withContext(ioDispatcher) {
            preferencesGateway.putString(
                CACHE_KEY_REGION,
                moshi.adapter(Region::class.java).toJson(region)
            )
        }
    }

    override suspend fun putCredential(credential: Credential?) {
        withContext(ioDispatcher) {
            preferencesGateway.putString(
                CACHE_KEY_CREDENTIAL,
                moshi.adapter(Credential::class.java).toJson(credential)
            )
        }
    }


    override suspend fun monitorUser(): Flow<User?> =
        withContext(ioDispatcher) {
            preferencesGateway.monitorPreferences().map { preferences ->
                preferences[stringPreferencesKey(CACHE_KEY_USER)]?.let {
                    moshi.adapter(User::class.java).fromJson(it)
                }
            }
        }

    override suspend fun monitorADConfig(key: String): Flow<ADShowRule?> =
        withContext(ioDispatcher) {
            preferencesGateway.monitorPreferences().map { preferences ->
                preferences[stringPreferencesKey(key)]?.let {
                    moshi.adapter(ADShowRule::class.java).fromJson(it)
                }
            }
        }

    override suspend fun monitorRegion(): Flow<Region?> =
        withContext(ioDispatcher) {
            preferencesGateway.monitorPreferences().map { preferences ->
                preferences[stringPreferencesKey(CACHE_KEY_REGION)]?.let {
                    moshi.adapter(Region::class.java).fromJson(it)
                }
            }
        }

    override suspend fun monitorCredential(): Flow<Credential?> =
        withContext(ioDispatcher) {
            preferencesGateway.monitorPreferences().map { preferences ->
                preferences[stringPreferencesKey(CACHE_KEY_CREDENTIAL)]?.let {
                    moshi.adapter(Credential::class.java).fromJson(it)
                }
            }
        }

    override suspend fun putLong(key: String, data: Long) {
        withContext(ioDispatcher) {
            preferencesGateway.putLong(key, data)
        }
    }

    override suspend fun monitorLong(key: String): Flow<Long?> =
        withContext(ioDispatcher) {
            preferencesGateway.monitorPreferences().map { preferences ->
                preferences[longPreferencesKey(key)]
            }
        }

    override suspend fun putInt(key: String, data: Int) {
        withContext(ioDispatcher) {
            preferencesGateway.putInt(key, data)
        }
    }

    override suspend fun monitorInt(key: String): Flow<Int?> =
        withContext(ioDispatcher) {
            preferencesGateway.monitorPreferences().map { preferences ->
                preferences[intPreferencesKey(key)]
            }
        }

    override suspend fun putString(key: String, data: String) {
        withContext(ioDispatcher) {
            preferencesGateway.putString(key, data)
        }
    }

    override suspend fun monitorString(key: String): Flow<String?> =
        withContext(ioDispatcher) {
            preferencesGateway.monitorPreferences().map { preferences ->
                preferences[stringPreferencesKey(key)]
            }
        }

    override suspend fun putBoolean(key: String, data: Boolean) {
        withContext(ioDispatcher) {
            preferencesGateway.putBoolean(key, data)
        }
    }

    override suspend fun monitorBoolean(key: String, defaultValue: Boolean): Flow<Boolean> =
        withContext(ioDispatcher) {
            preferencesGateway.monitorPreferences().map { preferences ->
                preferences[booleanPreferencesKey(key)] ?: defaultValue
            }
        }

}