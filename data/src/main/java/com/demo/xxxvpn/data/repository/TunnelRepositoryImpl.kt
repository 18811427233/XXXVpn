package com.demo.xxxvpn.data.repository

import android.content.Context
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.wireguard.android.backend.BackendException
import dagger.hilt.android.qualifiers.ApplicationContext
import com.demo.xxxvpn.data.gateway.WireGuardApiGateway
import com.demo.xxxvpn.data.mapper.HandshakeStateMapper
import com.demo.xxxvpn.data.mapper.TunnelStateMapper
import com.demo.xxxvpn.data.mapper.TunnelStatisticsMapper
import com.demo.xxxvpn.data.mapper.WireGuardBackendExceptionMapper
import com.demo.xxxvpn.data.mapper.WireGuardConfigMapper
import com.demo.xxxvpn.data.tunnel.WireGuardTunnel
import com.demo.xxxvpn.domain.entity.HandshakeState
import com.demo.xxxvpn.domain.entity.TunnelState
import com.demo.xxxvpn.domain.entity.TunnelStatistics
import com.demo.xxxvpn.domain.keys.NetworkKeys
import com.demo.xxxvpn.domain.qualifiers.IoDispatcher
import com.demo.xxxvpn.domain.repository.TunnelRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.net.InetAddress
import javax.inject.Inject

class TunnelRepositoryImpl @Inject constructor(
    @ApplicationContext private val applicationContext: Context,
    private val wireGuardApiGateway: WireGuardApiGateway,
    private val tunnelStateMapper: TunnelStateMapper,
    private val tunnelStatisticsMapper: TunnelStatisticsMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val wireGuardConfigMapper: WireGuardConfigMapper,
    private val handshakeStateMapper: HandshakeStateMapper,
    private val wireGuardTunnel: WireGuardTunnel,
    private val wireGuardBackendExceptionMapper: WireGuardBackendExceptionMapper
) : TunnelRepository {
    override suspend fun connectTunnel(region: String, port: Int?) {
        Timber.d("Connected Config1111")
        withContext(ioDispatcher) {

            try {

                Timber.d("Connected Config2222")
                val config = wireGuardConfigMapper(region, port)
                Timber.d("Connected Config: \n${config.toWgQuickString()}")
                wireGuardApiGateway.connectTunnel(wireGuardTunnel, config)
            } catch (e: Exception) {
                throw if (e is BackendException) wireGuardBackendExceptionMapper(e) else e
            }
        }
    }

    override suspend fun disconnectTunnel() {
        withContext(ioDispatcher) {
            wireGuardApiGateway.disconnectTunnel(wireGuardTunnel)
        }
    }

    override suspend fun notifyTunnelLoading() = withContext(ioDispatcher) {
        wireGuardTunnel.notifyTunnelStateLoading()
    }

    override suspend fun notifyTunnelConnected() = withContext(ioDispatcher) {
        wireGuardTunnel.notifyTunnelStateConnected()
    }

    override suspend fun notifyTunnelDisconnected() = withContext(ioDispatcher) {
        wireGuardTunnel.notifyTunnelStateDisconnected()
    }

    override suspend fun getCurrentTunnelConnectionState() = withContext(ioDispatcher) {
        tunnelStateMapper(wireGuardTunnel.tunnelState.first())
    }

    override fun monitorTunnelStateChanged(): Flow<TunnelState> =
        flow {
            emit(wireGuardApiGateway.getConnectionState(wireGuardTunnel))
            emitAll(wireGuardTunnel.tunnelState)
        }.map { tunnelStateMapper(it) }
            .flowOn(ioDispatcher)

    override suspend fun getConnectionStatistics(): TunnelStatistics = withContext(ioDispatcher) {
        tunnelStatisticsMapper(wireGuardApiGateway.getTunnelStatistics(wireGuardTunnel))
    }

    override suspend fun getHandshakeState(): HandshakeState = withContext(ioDispatcher) {
        val statistics = wireGuardApiGateway.getTunnelStatistics(wireGuardTunnel)
        handshakeStateMapper(statistics.peers().firstOrNull()?.let { statistics.peer(it) })
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun isPublicWebrootReachable() = withContext(ioDispatcher) {
        InetAddress.getByName(NetworkKeys.PUBLIC_WEBROOT_IP).isReachable(1000)
    }

    override suspend fun getDeviceId(): String? {
        return withContext(ioDispatcher) {
            AdvertisingIdClient.getAdvertisingIdInfo(applicationContext).id
        }
    }


}