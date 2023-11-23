package com.demo.xxxvpn.data.di

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ADModule {

    @Provides
    fun provideAd(): AdRequest {
        return AdRequest.Builder().build()
    }

    @Provides
    fun provideAdManager(): AdManagerAdRequest {
        return AdManagerAdRequest.Builder().build()
    }

}