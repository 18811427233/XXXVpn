package com.demo.xxxvpn.domain.usecase.tunnel;

/**
 * Disconnect VPN Tunnel Use Case
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/tunnel/DisconnectTunnelUseCase;", "", "tunnelRepository", "Lcom/demo/xxxvpn/domain/repository/TunnelRepository;", "resetLastConnectedTimestampUseCase", "Lcom/demo/xxxvpn/domain/usecase/tunnel/ResetLastConnectedTimestampUseCase;", "(Lcom/demo/xxxvpn/domain/repository/TunnelRepository;Lcom/demo/xxxvpn/domain/usecase/tunnel/ResetLastConnectedTimestampUseCase;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain"})
public final class DisconnectTunnelUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.repository.TunnelRepository tunnelRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.usecase.tunnel.ResetLastConnectedTimestampUseCase resetLastConnectedTimestampUseCase = null;
    
    @javax.inject.Inject
    public DisconnectTunnelUseCase(@org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.repository.TunnelRepository tunnelRepository, @org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.usecase.tunnel.ResetLastConnectedTimestampUseCase resetLastConnectedTimestampUseCase) {
        super();
    }
    
    /**
     * Disconnect from a the current VPN Tunnel
     *
     * Checks whether the current state is [TunnelState.Disconnected]. If true, then it will notify
     * that tunnel is actually Disconnected and throw a [RuntimeException], otherwise it will
     * disconnect the current tunnel, while also resetting the last saved connected timestamp
     * to 0 after the tunnel is disconnected.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}