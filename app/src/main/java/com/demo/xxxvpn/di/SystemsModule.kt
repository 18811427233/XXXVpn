package com.demo.xxxvpn.di

import android.app.NotificationManager
import android.content.ClipboardManager
import android.content.Context
import android.net.ConnectivityManager
import android.os.PowerManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SystemsModule {
    @Provides
    fun provideConnectivityManager(@ApplicationContext applicationContext: Context): ConnectivityManager =
        applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Provides
    fun provideClipboardManager(@ApplicationContext applicationContext: Context): ClipboardManager =
        applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    @Provides
    fun providePowerManager(@ApplicationContext applicationContext: Context): PowerManager =
        applicationContext.getSystemService(Context.POWER_SERVICE) as PowerManager
}