package com.demo.xxxvpn.data.gateway

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface PreferencesGateway {
    /**
     * Put string
     *
     * @param key
     * @param value
     */
    suspend fun putString(key: String, value: String)

    /**
     * Put string set
     *
     * @param key
     * @param value
     */
    suspend fun putStringSet(key: String, value: MutableSet<String>)

    /**
     * Put int
     *
     * @param key
     * @param value
     */
    suspend fun putInt(key: String, value: Int)

    /**
     * Put long
     *
     * @param key
     * @param value
     */
    suspend fun putLong(key: String, value: Long)

    /**
     * Put float
     *
     * @param key
     * @param value
     */
    suspend fun putFloat(key: String, value: Float)

    /**
     * Put boolean
     *
     * @param key
     * @param value
     */
    suspend fun putBoolean(key: String, value: Boolean)

    /**
     * Monitor preferences
     * @return Flow of current preferences inside the datastore
     */
    fun monitorPreferences(): Flow<Preferences>

    /**
     * Monitor string
     *
     * @param key
     * @param defaultValue
     * @return current preference and future updates as a flow
     */
    fun monitorString(key: String, defaultValue: String?): Flow<String?>

    /**
     * Monitor string set
     *
     * @param key
     * @param defaultValue
     * @return current preference and future updates as a flow
     */
    fun monitorStringSet(key: String, defaultValue: MutableSet<String>?): Flow<MutableSet<String>?>

    /**
     * Monitor int
     *
     * @param key
     * @param defaultValue
     * @return current preference and future updates as a flow
     */
    fun monitorInt(key: String, defaultValue: Int): Flow<Int>

    /**
     * Monitor long
     *
     * @param key
     * @param defaultValue
     * @return current preference and future updates as a flow
     */
    fun monitorLong(key: String, defaultValue: Long): Flow<Long>

    /**
     * Monitor float
     *
     * @param key
     * @param defaultValue
     * @return current preference and future updates as a flow
     */
    fun monitorFloat(key: String, defaultValue: Float): Flow<Float>

    /**
     * Monitor boolean
     *
     * @param key
     * @param defaultValue
     * @return current preference and future updates as a flow
     */
    fun monitorBoolean(key: String, defaultValue: Boolean): Flow<Boolean>

    /**
     * Remove a single preference data by its key
     * @param key
     */
    suspend fun removeByKey(key: String)

    /**
     * Remove multiple preference data by its keys
     * @param keys
     */
    suspend fun removeByKeys(keys: Array<String>)
}