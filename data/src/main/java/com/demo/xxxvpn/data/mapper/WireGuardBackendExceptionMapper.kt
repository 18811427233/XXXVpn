package com.demo.xxxvpn.data.mapper

import com.wireguard.android.backend.BackendException
import com.demo.xxxvpn.domain.exception.WireGuardBackendException
import javax.inject.Inject

class WireGuardBackendExceptionMapper @Inject constructor() {
    operator fun invoke(e: BackendException): WireGuardBackendException =
        when (e.reason) {
            BackendException.Reason.TUNNEL_MISSING_CONFIG -> WireGuardBackendException.MissingTunnelConfig
            BackendException.Reason.VPN_NOT_AUTHORIZED -> WireGuardBackendException.VpnPermissionNotUnauthorized
            BackendException.Reason.UNABLE_TO_START_VPN -> WireGuardBackendException.VpnConnectionTimeout
            BackendException.Reason.TUN_CREATION_ERROR -> WireGuardBackendException.TunnelCreationError
            BackendException.Reason.GO_ACTIVATION_ERROR_CODE -> WireGuardBackendException.TunnelHandleNotFound
            BackendException.Reason.DNS_RESOLUTION_FAILURE -> WireGuardBackendException.DnsResolutionFailure
            else -> WireGuardBackendException.UnknownError
        }
}