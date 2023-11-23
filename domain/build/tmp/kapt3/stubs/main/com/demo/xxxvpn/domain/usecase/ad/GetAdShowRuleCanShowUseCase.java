package com.demo.xxxvpn.domain.usecase.ad;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/ad/GetAdShowRuleCanShowUseCase;", "", "cacheRepository", "Lcom/demo/xxxvpn/domain/repository/CacheRepository;", "adRepository", "Lcom/demo/xxxvpn/domain/repository/ADRepository;", "(Lcom/demo/xxxvpn/domain/repository/CacheRepository;Lcom/demo/xxxvpn/domain/repository/ADRepository;)V", "invoke", "", "key", "", "preLoad", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNotToday", "timestamp", "", "cdDay", "", "domain"})
public final class GetAdShowRuleCanShowUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.repository.CacheRepository cacheRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.repository.ADRepository adRepository = null;
    
    @javax.inject.Inject
    public GetAdShowRuleCanShowUseCase(@org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.repository.CacheRepository cacheRepository, @org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.repository.ADRepository adRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean preLoad, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final boolean isNotToday(long timestamp, int cdDay) {
        return false;
    }
}