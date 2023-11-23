package com.demo.xxxvpn.domain.entity;

/**
 * VPN tunnel connection peer handshake state
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/demo/xxxvpn/domain/entity/HandshakeState;", "", "(Ljava/lang/String;I)V", "STRONG", "WEAK", "NEVER", "Companion", "domain"})
public enum HandshakeState {
    /*public static final*/ STRONG /* = new STRONG() */,
    /*public static final*/ WEAK /* = new WEAK() */,
    /*public static final*/ NEVER /* = new NEVER() */;
    public static final int WEAK_TIME_LIMIT_SEC = 180;
    @org.jetbrains.annotations.NotNull
    public static final com.demo.xxxvpn.domain.entity.HandshakeState.Companion Companion = null;
    
    HandshakeState() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.demo.xxxvpn.domain.entity.HandshakeState> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/demo/xxxvpn/domain/entity/HandshakeState$Companion;", "", "()V", "WEAK_TIME_LIMIT_SEC", "", "domain"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}