package com.demo.xxxvpn.domain.usecase.tunnel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/tunnel/ConnectTunnelUseCase;", "", "tunnelRepository", "Lcom/demo/xxxvpn/domain/repository/TunnelRepository;", "(Lcom/demo/xxxvpn/domain/repository/TunnelRepository;)V", "invoke", "", "region", "Lcom/demo/xxxvpn/domain/entity/network/Region;", "portIndex", "", "(Lcom/demo/xxxvpn/domain/entity/network/Region;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "domain"})
public final class ConnectTunnelUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.repository.TunnelRepository tunnelRepository = null;
    public static final int MAX_TIMEOUT_RETRY = 3;
    @org.jetbrains.annotations.NotNull
    public static final com.demo.xxxvpn.domain.usecase.tunnel.ConnectTunnelUseCase.Companion Companion = null;
    
    @javax.inject.Inject
    public ConnectTunnelUseCase(@org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.repository.TunnelRepository tunnelRepository) {
        super();
    }
    
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
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.Nullable
    com.demo.xxxvpn.domain.entity.network.Region region, int portIndex, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/tunnel/ConnectTunnelUseCase$Companion;", "", "()V", "MAX_TIMEOUT_RETRY", "", "domain"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}