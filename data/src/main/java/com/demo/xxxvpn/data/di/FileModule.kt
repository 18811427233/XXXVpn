package com.demo.xxxvpn.data.di

import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.demo.xxxvpn.domain.qualifiers.EncryptionKey
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FileModule {

    @EncryptionKey
    @Provides
    @Singleton
    fun provideEncryptionKey(): String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    @Provides
    @Singleton
    fun provideEncryptionScheme(): EncryptedFile.FileEncryptionScheme =
        EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
}