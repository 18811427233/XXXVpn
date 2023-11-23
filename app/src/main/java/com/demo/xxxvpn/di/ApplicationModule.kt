package com.demo.xxxvpn.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.demo.xxxvpn.domain.qualifiers.SettingsDataStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Singleton
    @SettingsDataStore
    @Provides
    fun provideSettingsDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create {
            context.preferencesDataStoreFile("settings")
        }
}