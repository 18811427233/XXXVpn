package com.demo.xxxvpn.data.cache

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.first

/**
 * Template to manage a Shared Flow object
 */
internal interface SharedFlowTemplate<T> {
    val flowable: MutableSharedFlow<T>

    suspend fun get(): T = monitor().first()

    suspend fun set(value: T) = flowable.emit(value)

    fun monitor(): Flow<T> = flowable.asSharedFlow()
}