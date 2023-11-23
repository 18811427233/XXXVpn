package com.demo.xxxvpn.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.demo.xxxvpn.service.VpnTunnelServiceWrapper
import com.demo.xxxvpn.service.VpnTunnelServiceWrapperImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class TunnelModule {
    @Binds
    abstract fun bindsVpnTunnelServiceWrapper(implementation: VpnTunnelServiceWrapperImpl): VpnTunnelServiceWrapper
}