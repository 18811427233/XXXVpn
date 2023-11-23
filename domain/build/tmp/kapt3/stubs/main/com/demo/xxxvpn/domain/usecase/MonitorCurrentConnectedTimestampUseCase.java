package com.demo.xxxvpn.domain.usecase;

/**
 * Use Case to get the current user's VPN connection timestamp
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/MonitorCurrentConnectedTimestampUseCase;", "", "cacheRepository", "Lcom/demo/xxxvpn/domain/repository/CacheRepository;", "(Lcom/demo/xxxvpn/domain/repository/CacheRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain"})
public final class MonitorCurrentConnectedTimestampUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.repository.CacheRepository cacheRepository = null;
    
    @javax.inject.Inject
    public MonitorCurrentConnectedTimestampUseCase(@org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.repository.CacheRepository cacheRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.Long>> $completion) {
        return null;
    }
}