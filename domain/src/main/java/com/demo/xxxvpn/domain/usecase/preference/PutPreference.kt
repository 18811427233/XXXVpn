package com.demo.xxxvpn.domain.usecase.preference


/**
 * Put preference
 *
 * @param T preference type
 */
fun interface PutPreference<T> {
    /**
     * Invoke
     * @param key name of the preference
     * @param value value to set
     */
    suspend operator fun invoke(key: String?, value: T?)
}
