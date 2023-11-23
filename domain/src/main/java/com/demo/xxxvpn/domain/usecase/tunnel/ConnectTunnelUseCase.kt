package com.demo.xxxvpn.domain.usecase.tunnel

import com.demo.xxxvpn.domain.entity.network.Region
import com.demo.xxxvpn.domain.entity.TunnelState
import com.demo.xxxvpn.domain.exception.WireGuardBackendException
import com.demo.xxxvpn.domain.repository.TunnelRepository
import kotlinx.coroutines.ensureActive
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class ConnectTunnelUseCase @Inject constructor(
    private val tunnelRepository: TunnelRepository,
) {
    /**
     * Connect to a VPN tunnel
     *
     * Will set the current Tunnel state as Loading by calling notifyTunnelLoading. WireGuard doesn't
     * provide callbacks for loading state. Next, it will check whether the current state
     * is [TunnelState.Connected]. If true, then it will notify that tunnel is actually Connected
     * and throw a [RuntimeException], otherwise it will connect the current device to the VPN tunnel.
     *
     * Connecting to Vpn tunnel will retry for [MAX_TIMEOUT_RETRY] times, because when connecting to
     * tunnel, a timeout exception can happen because WireGuard only allows 2s to connect, otherwise
     * it would throw [WireGuardBackendException.VpnConnectionTimeout].
     *
     * @throws RuntimeException when tunnel is already connected
     * @throws WireGuardBackendException.TimeoutRetryLimitReached when maximum retry has been reached
     */
    suspend operator fun invoke(region: Region?, portIndex: Int) {
        tunnelRepository.notifyTunnelLoading()

        if (tunnelRepository.getCurrentTunnelConnectionState() == TunnelState.Connected) {
            tunnelRepository.notifyTunnelConnected()
            throw RuntimeException("Tunnel is already connected!")
        }

        val connectList = region?.endpointList?.map {
            println("重试地址是：${it.address} 端口是：${it.portList[portIndex]}")
            it.address to it.portList[portIndex]
        } ?: mutableListOf()

        run block@{
            repeat(connectList.size) {
                val server = connectList[it]
                try {
                    coroutineContext.ensureActive()
                    tunnelRepository.connectTunnel(server.first, server.second)
                    return@block
                } catch (e: Exception) {
                    if (e !is WireGuardBackendException.VpnConnectionTimeout) {
                        tunnelRepository.notifyTunnelDisconnected()
                        throw e
                    }
                }
            }
            tunnelRepository.notifyTunnelDisconnected()
            throw WireGuardBackendException.TimeoutRetryLimitReached
        }
    }

    internal companion object {
        const val MAX_TIMEOUT_RETRY = 3
    }
}