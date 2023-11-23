package com.demo.xxxvpn.domain.exception

sealed class WireGuardBackendException(message: String) : RuntimeException(message) {
    data object MissingTunnelConfig : WireGuardBackendException("Tunnel config is missing!")

    data object VpnPermissionNotUnauthorized : WireGuardBackendException("User did not allow the VPN permission on this device!")

    data object VpnConnectionTimeout : WireGuardBackendException("Timeout when starting Vpn. WireGuard limits starting time to 2 seconds, retry required!")

    data object TunnelCreationError : WireGuardBackendException("Tunnel creation failed!")

    data object TunnelHandleNotFound : WireGuardBackendException("Tunnel handle not found!")

    data object DnsResolutionFailure : WireGuardBackendException("Failed to resolve Dns!")

    data object TimeoutRetryLimitReached : WireGuardBackendException("Timeout retry limit has been reached! Stopping now")

    data object UnknownError : WireGuardBackendException("There's an unknown error when connecting to GoBackend!")
}