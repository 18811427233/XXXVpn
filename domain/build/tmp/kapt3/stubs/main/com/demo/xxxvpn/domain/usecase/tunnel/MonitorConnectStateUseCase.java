package com.demo.xxxvpn.domain.usecase.tunnel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/tunnel/MonitorConnectStateUseCase;", "", "monitorTunnelStateUseCase", "Lcom/demo/xxxvpn/domain/usecase/tunnel/MonitorTunnelStateUseCase;", "monitorNetworkConnectivityUseCase", "Lcom/demo/xxxvpn/domain/usecase/MonitorNetworkConnectivityUseCase;", "monitorSelectedRegionUseCase", "Lcom/demo/xxxvpn/domain/usecase/tunnel/MonitorSelectedRegionUseCase;", "saveLastConnectedTimestampUseCase", "Lcom/demo/xxxvpn/domain/usecase/tunnel/SaveLastConnectedTimestampUseCase;", "tunnelRepository", "Lcom/demo/xxxvpn/domain/repository/TunnelRepository;", "(Lcom/demo/xxxvpn/domain/usecase/tunnel/MonitorTunnelStateUseCase;Lcom/demo/xxxvpn/domain/usecase/MonitorNetworkConnectivityUseCase;Lcom/demo/xxxvpn/domain/usecase/tunnel/MonitorSelectedRegionUseCase;Lcom/demo/xxxvpn/domain/usecase/tunnel/SaveLastConnectedTimestampUseCase;Lcom/demo/xxxvpn/domain/repository/TunnelRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState;", "isConnectedToVpnServer", "", "networkState", "Lcom/demo/xxxvpn/domain/entity/NetworkState;", "handshakeState", "Lcom/demo/xxxvpn/domain/entity/HandshakeState;", "isNeverConnectedToVpnServer", "mergeHandshakeWithPublicWebrootReachableState", "(Lcom/demo/xxxvpn/domain/entity/HandshakeState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "monitorTunnelConnectedState", "monitorVpnConnectedState", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState$Connected;", "Companion", "domain"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
public final class MonitorConnectStateUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.usecase.tunnel.MonitorTunnelStateUseCase monitorTunnelStateUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.usecase.MonitorNetworkConnectivityUseCase monitorNetworkConnectivityUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.usecase.tunnel.MonitorSelectedRegionUseCase monitorSelectedRegionUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.usecase.tunnel.SaveLastConnectedTimestampUseCase saveLastConnectedTimestampUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.repository.TunnelRepository tunnelRepository = null;
    public static final long FETCH_STATISTICS_DELAY_INTERVAL = 1000L;
    @org.jetbrains.annotations.NotNull
    public static final com.demo.xxxvpn.domain.usecase.tunnel.MonitorConnectStateUseCase.Companion Companion = null;
    
    @javax.inject.Inject
    public MonitorConnectStateUseCase(@org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.usecase.tunnel.MonitorTunnelStateUseCase monitorTunnelStateUseCase, @org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.usecase.MonitorNetworkConnectivityUseCase monitorNetworkConnectivityUseCase, @org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.usecase.tunnel.MonitorSelectedRegionUseCase monitorSelectedRegionUseCase, @org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.usecase.tunnel.SaveLastConnectedTimestampUseCase saveLastConnectedTimestampUseCase, @org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.repository.TunnelRepository tunnelRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.tunnel.ConnectState> invoke() {
        return null;
    }
    
    private final kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.tunnel.ConnectState> monitorTunnelConnectedState(com.demo.xxxvpn.domain.entity.NetworkState networkState) {
        return null;
    }
    
    /**
     * This flow guarantees that device is connected to both Android VPN Gateway & VPN Server
     * Connected = Connected to Android VPN Gateway + Connected to VPN Server
     */
    private final kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.tunnel.ConnectState.Connected> monitorVpnConnectedState(com.demo.xxxvpn.domain.entity.HandshakeState handshakeState) {
        return null;
    }
    
    /**
     * This method checks whether the Android VPN Gateway is actually connected to the VPN server
     * It checks whether device has an internet connection
     * Then, it also checks whether handshake was received recently from peer connection
     */
    private final boolean isConnectedToVpnServer(com.demo.xxxvpn.domain.entity.NetworkState networkState, com.demo.xxxvpn.domain.entity.HandshakeState handshakeState) {
        return false;
    }
    
    /**
     * This method checks whether the Android VPN Gateway is actually connected to the VPN server
     * It checks whether device has an internet connection
     * Then, it also checks whether handshake was never received from peer previously, to determine
     * that the user was connected for the first time
     */
    private final boolean isNeverConnectedToVpnServer(com.demo.xxxvpn.domain.entity.NetworkState networkState, com.demo.xxxvpn.domain.entity.HandshakeState handshakeState) {
        return false;
    }
    
    /**
     * This method combines the Handshake state and the network reachable state by pinging a public
     * webroot to see if the device is actually connected to an active network. The WireGuard library
     * Handshake state can be miscalculated by as much as 120-180 seconds, because that is the amount of time
     * it takes for WireGuard to renew it's Handshake state, and there's no way of controlling it.
     * By combining this, we can dramatically reduce the miscalculation to [FETCH_STATISTICS_DELAY_INTERVAL] seconds.
     *
     * This method checks if a prior Handshake has been established, and then it checks whether the
     * public webroot is reachable, and if both condition are not met, it will alter the Handshake state to WEAK
     * regardless of the Handshake state returned by WireGuard statistics
     */
    private final java.lang.Object mergeHandshakeWithPublicWebrootReachableState(com.demo.xxxvpn.domain.entity.HandshakeState handshakeState, kotlin.coroutines.Continuation<? super com.demo.xxxvpn.domain.entity.HandshakeState> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/tunnel/MonitorConnectStateUseCase$Companion;", "", "()V", "FETCH_STATISTICS_DELAY_INTERVAL", "", "domain"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}