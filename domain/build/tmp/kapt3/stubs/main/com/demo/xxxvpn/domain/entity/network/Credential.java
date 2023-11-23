package com.demo.xxxvpn.domain.entity.network;

@com.squareup.moshi.JsonClass(generateAdapter = false)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/demo/xxxvpn/domain/entity/network/Credential;", "", "dns", "", "ipV4", "ipV6", "peerPublicKey", "preSharedKey", "privateKey", "publicKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDns", "()Ljava/lang/String;", "getIpV4", "getIpV6", "getPeerPublicKey", "getPreSharedKey", "getPrivateKey", "getPublicKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "domain"})
public final class Credential {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String dns = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String ipV4 = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String ipV6 = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String peerPublicKey = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String preSharedKey = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String privateKey = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String publicKey = null;
    
    public Credential(@org.jetbrains.annotations.NotNull
    java.lang.String dns, @org.jetbrains.annotations.NotNull
    java.lang.String ipV4, @org.jetbrains.annotations.NotNull
    java.lang.String ipV6, @org.jetbrains.annotations.NotNull
    java.lang.String peerPublicKey, @org.jetbrains.annotations.NotNull
    java.lang.String preSharedKey, @org.jetbrains.annotations.NotNull
    java.lang.String privateKey, @org.jetbrains.annotations.NotNull
    java.lang.String publicKey) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDns() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIpV4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIpV6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPeerPublicKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPreSharedKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrivateKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPublicKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.demo.xxxvpn.domain.entity.network.Credential copy(@org.jetbrains.annotations.NotNull
    java.lang.String dns, @org.jetbrains.annotations.NotNull
    java.lang.String ipV4, @org.jetbrains.annotations.NotNull
    java.lang.String ipV6, @org.jetbrains.annotations.NotNull
    java.lang.String peerPublicKey, @org.jetbrains.annotations.NotNull
    java.lang.String preSharedKey, @org.jetbrains.annotations.NotNull
    java.lang.String privateKey, @org.jetbrains.annotations.NotNull
    java.lang.String publicKey) {
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