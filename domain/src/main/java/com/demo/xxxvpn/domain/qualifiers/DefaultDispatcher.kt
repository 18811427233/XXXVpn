package com.demo.xxxvpn.domain.qualifiers

import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

/**
 * Default dispatcher
 * refer to [Dispatchers.Default]
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DefaultDispatcher