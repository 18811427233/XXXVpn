package com.demo.xxxvpn.domain.usecase.ad;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/ad/MonitorAdUseCase;", "", "adRepository", "Lcom/demo/xxxvpn/domain/repository/ADRepository;", "cacheRepository", "Lcom/demo/xxxvpn/domain/repository/CacheRepository;", "preLoadAdUseCase", "Lcom/demo/xxxvpn/domain/usecase/ad/PreLoadAdUseCase;", "(Lcom/demo/xxxvpn/domain/repository/ADRepository;Lcom/demo/xxxvpn/domain/repository/CacheRepository;Lcom/demo/xxxvpn/domain/usecase/ad/PreLoadAdUseCase;)V", "invoke", "", "key", "", "stopServer", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain"})
public final class MonitorAdUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.repository.ADRepository adRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.repository.CacheRepository cacheRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.usecase.ad.PreLoadAdUseCase preLoadAdUseCase = null;
    
    @javax.inject.Inject
    public MonitorAdUseCase(@org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.repository.ADRepository adRepository, @org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.repository.CacheRepository cacheRepository, @org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.usecase.ad.PreLoadAdUseCase preLoadAdUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> stopServer, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}