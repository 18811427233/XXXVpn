package com.demo.xxxvpn.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\r\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u0010\u001a\u00020\u0011H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u0012\u001a\u00020\u0013H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H&J\u0011\u0010\u0016\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u0017\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u0018\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/demo/xxxvpn/domain/repository/TunnelRepository;", "", "connectTunnel", "", "region", "", "port", "", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectTunnel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConnectionStatistics", "Lcom/demo/xxxvpn/domain/entity/TunnelStatistics;", "getCurrentTunnelConnectionState", "Lcom/demo/xxxvpn/domain/entity/TunnelState;", "getDeviceId", "getHandshakeState", "Lcom/demo/xxxvpn/domain/entity/HandshakeState;", "isPublicWebrootReachable", "", "monitorTunnelStateChanged", "Lkotlinx/coroutines/flow/Flow;", "notifyTunnelConnected", "notifyTunnelDisconnected", "notifyTunnelLoading", "domain"})
public abstract interface TunnelRepository {
    
    /**
     * Connect to tunnel
     *
     * @param region the region of the VPN server
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object connectTunnel(@org.jetbrains.annotations.NotNull
    java.lang.String region, @org.jetbrains.annotations.Nullable
    java.lang.Integer port, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Disconnect the current running tunnel
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object disconnectTunnel(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Notify that tunnel is currently in Loading State
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object notifyTunnelLoading(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Notify that tunnel is currently in Connected State
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object notifyTunnelConnected(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Notify that tunnel is currently in Disconnected State
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object notifyTunnelDisconnected(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    /**
     * Get the current tunnel connection state
     *
     * @return state as [TunnelState]
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCurrentTunnelConnectionState(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.demo.xxxvpn.domain.entity.TunnelState> $completion);
    
    /**
     * Monitor tunnel state changed
     *
     * @return Flow of [TunnelState]
     */
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.TunnelState> monitorTunnelStateChanged();
    
    /**
     * Get the current connected tunnel statistics
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getConnectionStatistics(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.demo.xxxvpn.domain.entity.TunnelStatistics> $completion);
    
    /**
     * Get the current connected tunnel handshake state
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHandshakeState(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.demo.xxxvpn.domain.entity.HandshakeState> $completion);
    
    /**
     * Check if a public webroot is reachable
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object isPublicWebrootReachable(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDeviceId(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
}