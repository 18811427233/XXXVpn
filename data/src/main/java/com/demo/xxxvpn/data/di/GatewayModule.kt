package com.demo.xxxvpn.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.demo.xxxvpn.data.facade.AndroidDeviceGatewayImpl
import com.demo.xxxvpn.data.facade.WireGuardApiGatewayImpl
import com.demo.xxxvpn.data.gateway.DeviceGateway
import com.demo.xxxvpn.data.gateway.PreferencesGateway
import com.demo.xxxvpn.data.gateway.WireGuardApiGateway
import com.demo.xxxvpn.data.preferences.AppPreferencesDatastore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GatewayModule {
    @Binds
    abstract fun bindAppPreferencesGateway(implementation: AppPreferencesDatastore): PreferencesGateway

    @Singleton
    @Binds
    abstract fun bindWireGuardGateway(implementation: WireGuardApiGatewayImpl): WireGuardApiGateway

    @Singleton
    @Binds
    abstract fun bindDeviceGateway(implementation: AndroidDeviceGatewayImpl): DeviceGateway

}
