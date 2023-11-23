package com.demo.xxxvpn.data.di

import com.demo.xxxvpn.data.repository.ADRepositoryImpl
import com.demo.xxxvpn.data.repository.AndroidSystemRepositoryImpl
import com.demo.xxxvpn.data.repository.CacheRepositoryImpl
import com.demo.xxxvpn.data.repository.TunnelRepositoryImpl
import com.demo.xxxvpn.domain.repository.ADRepository
import com.demo.xxxvpn.domain.repository.AndroidSystemRepository
import com.demo.xxxvpn.domain.repository.CacheRepository
import com.demo.xxxvpn.domain.repository.TunnelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindCacheRepository(repository: CacheRepositoryImpl): CacheRepository

    @Singleton
    @Binds
    internal abstract fun bindTunnelRepository(repository: TunnelRepositoryImpl): TunnelRepository

    @Singleton
    @Binds
    internal abstract fun bindConnectionRepository(repository: AndroidSystemRepositoryImpl): AndroidSystemRepository

    @Singleton
    @Binds
    internal abstract fun bindADRepository(repository: ADRepositoryImpl): ADRepository

}
