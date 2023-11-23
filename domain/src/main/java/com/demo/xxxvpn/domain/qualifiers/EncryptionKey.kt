package com.demo.xxxvpn.domain.qualifiers

import javax.inject.Qualifier

/**
 * Qualifier for Android Master Key to encrypt and decrypt file
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class EncryptionKey
