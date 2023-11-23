package com.demo.xxxvpn.domain.entity.tunnel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState;", "", "Connected", "Connecting", "Disconnected", "Reconnecting", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState$Connected;", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState$Connecting;", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState$Disconnected;", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState$Reconnecting;", "domain"})
public abstract interface ConnectState {
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState$Connected;", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState;", "statistics", "Lcom/demo/xxxvpn/domain/entity/TunnelStatistics;", "handshakeState", "Lcom/demo/xxxvpn/domain/entity/HandshakeState;", "region", "Lcom/demo/xxxvpn/domain/entity/network/Region;", "(Lcom/demo/xxxvpn/domain/entity/TunnelStatistics;Lcom/demo/xxxvpn/domain/entity/HandshakeState;Lcom/demo/xxxvpn/domain/entity/network/Region;)V", "getHandshakeState", "()Lcom/demo/xxxvpn/domain/entity/HandshakeState;", "getRegion", "()Lcom/demo/xxxvpn/domain/entity/network/Region;", "getStatistics", "()Lcom/demo/xxxvpn/domain/entity/TunnelStatistics;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class Connected implements com.demo.xxxvpn.domain.entity.tunnel.ConnectState {
        @org.jetbrains.annotations.NotNull
        private final com.demo.xxxvpn.domain.entity.TunnelStatistics statistics = null;
        @org.jetbrains.annotations.NotNull
        private final com.demo.xxxvpn.domain.entity.HandshakeState handshakeState = null;
        @org.jetbrains.annotations.Nullable
        private final com.demo.xxxvpn.domain.entity.network.Region region = null;
        
        public Connected(@org.jetbrains.annotations.NotNull
        com.demo.xxxvpn.domain.entity.TunnelStatistics statistics, @org.jetbrains.annotations.NotNull
        com.demo.xxxvpn.domain.entity.HandshakeState handshakeState, @org.jetbrains.annotations.Nullable
        com.demo.xxxvpn.domain.entity.network.Region region) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.demo.xxxvpn.domain.entity.TunnelStatistics getStatistics() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.demo.xxxvpn.domain.entity.HandshakeState getHandshakeState() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.demo.xxxvpn.domain.entity.network.Region getRegion() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.demo.xxxvpn.domain.entity.TunnelStatistics component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.demo.xxxvpn.domain.entity.HandshakeState component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.demo.xxxvpn.domain.entity.network.Region component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.demo.xxxvpn.domain.entity.tunnel.ConnectState.Connected copy(@org.jetbrains.annotations.NotNull
        com.demo.xxxvpn.domain.entity.TunnelStatistics statistics, @org.jetbrains.annotations.NotNull
        com.demo.xxxvpn.domain.entity.HandshakeState handshakeState, @org.jetbrains.annotations.Nullable
        com.demo.xxxvpn.domain.entity.network.Region region) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState$Connecting;", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class Connecting implements com.demo.xxxvpn.domain.entity.tunnel.ConnectState {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.entity.tunnel.ConnectState.Connecting INSTANCE = null;
        
        private Connecting() {
            super();
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState$Disconnected;", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class Disconnected implements com.demo.xxxvpn.domain.entity.tunnel.ConnectState {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.entity.tunnel.ConnectState.Disconnected INSTANCE = null;
        
        private Disconnected() {
            super();
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState$Reconnecting;", "Lcom/demo/xxxvpn/domain/entity/tunnel/ConnectState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class Reconnecting implements com.demo.xxxvpn.domain.entity.tunnel.ConnectState {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.entity.tunnel.ConnectState.Reconnecting INSTANCE = null;
        
        private Reconnecting() {
            super();
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}