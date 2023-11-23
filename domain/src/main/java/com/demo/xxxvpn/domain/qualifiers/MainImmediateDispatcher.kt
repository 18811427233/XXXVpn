package com.demo.xxxvpn.domain.qualifiers

import javax.inject.Qualifier

/**
 * Main immediate dispatcher, it will run immediately
 * refer to Dispatchers.Main.immediate
 */
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainImmediateDispatcher