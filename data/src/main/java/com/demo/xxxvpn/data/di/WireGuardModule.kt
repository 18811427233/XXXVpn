package com.demo.xxxvpn.data.di

import android.content.Context
import com.wireguard.android.backend.GoBackend
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object WireGuardModule {
    @Provides
    fun provideGoBackend(@ApplicationContext applicationContext: Context) =
        GoBackend(applicationContext)
}