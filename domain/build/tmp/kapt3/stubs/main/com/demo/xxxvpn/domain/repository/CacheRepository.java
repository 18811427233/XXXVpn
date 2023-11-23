package com.demo.xxxvpn.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\bf\u0018\u0000 02\u00020\u0001:\u00010J!\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J#\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J!\u0010$\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0013H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J!\u0010&\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0015H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u001b\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u0017H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J!\u0010+\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\u001b\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010\u001aH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/demo/xxxvpn/domain/repository/CacheRepository;", "", "monitorADConfig", "Lkotlinx/coroutines/flow/Flow;", "Lcom/demo/xxxvpn/domain/entity/network/ADShowRule;", "key", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "monitorADEvent", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/demo/xxxvpn/domain/ADEvent;", "monitorBoolean", "", "defaultValue", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "monitorCredential", "Lcom/demo/xxxvpn/domain/entity/network/Credential;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "monitorInt", "", "monitorLong", "", "monitorRegion", "Lcom/demo/xxxvpn/domain/entity/network/Region;", "monitorString", "monitorUser", "Lcom/demo/xxxvpn/domain/entity/network/User;", "putADConfig", "", "adShowRule", "(Ljava/lang/String;Lcom/demo/xxxvpn/domain/entity/network/ADShowRule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putBoolean", "data", "putCredential", "credential", "(Lcom/demo/xxxvpn/domain/entity/network/Credential;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putInt", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putLong", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putRegion", "region", "(Lcom/demo/xxxvpn/domain/entity/network/Region;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putString", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putUser", "user", "(Lcom/demo/xxxvpn/domain/entity/network/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "domain"})
public abstract interface CacheRepository {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CACHE_KEY_USER = "key_user";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CACHE_KEY_REGION = "key_region";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CACHE_KEY_BILL = "key_bill";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CACHE_KEY_CREDENTIAL = "key_credential";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CACHE_KEY_LAST_CONNECT_TIME = "key_last_connect_time";
    @org.jetbrains.annotations.NotNull
    public static final com.demo.xxxvpn.domain.repository.CacheRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.MutableStateFlow<com.demo.xxxvpn.domain.ADEvent> monitorADEvent();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putUser(@org.jetbrains.annotations.Nullable
    com.demo.xxxvpn.domain.entity.network.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putADConfig(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.Nullable
    com.demo.xxxvpn.domain.entity.network.ADShowRule adShowRule, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putRegion(@org.jetbrains.annotations.Nullable
    com.demo.xxxvpn.domain.entity.network.Region region, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putCredential(@org.jetbrains.annotations.Nullable
    com.demo.xxxvpn.domain.entity.network.Credential credential, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object monitorUser(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.network.User>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object monitorADConfig(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.network.ADShowRule>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object monitorRegion(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.network.Region>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object monitorCredential(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.network.Credential>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putLong(@org.jetbrains.annotations.NotNull
    java.lang.String key, long data, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object monitorLong(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.Long>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putInt(@org.jetbrains.annotations.NotNull
    java.lang.String key, int data, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object monitorInt(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.Integer>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putString(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String data, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object monitorString(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.String>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object putBoolean(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean data, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object monitorBoolean(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean defaultValue, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.Boolean>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/demo/xxxvpn/domain/repository/CacheRepository$Companion;", "", "()V", "CACHE_KEY_BILL", "", "CACHE_KEY_CREDENTIAL", "CACHE_KEY_LAST_CONNECT_TIME", "CACHE_KEY_REGION", "CACHE_KEY_USER", "domain"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CACHE_KEY_USER = "key_user";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CACHE_KEY_REGION = "key_region";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CACHE_KEY_BILL = "key_bill";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CACHE_KEY_CREDENTIAL = "key_credential";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String CACHE_KEY_LAST_CONNECT_TIME = "key_last_connect_time";
        
        private Companion() {
            super();
        }
    }
}