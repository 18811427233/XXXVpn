package com.demo.xxxvpn.domain.usecase;

/**
 * Use Case to receive updates regarding device connectivity state
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/MonitorNetworkConnectivityUseCase;", "", "androidSystemRepository", "Lcom/demo/xxxvpn/domain/repository/AndroidSystemRepository;", "(Lcom/demo/xxxvpn/domain/repository/AndroidSystemRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/demo/xxxvpn/domain/entity/NetworkState;", "domain"})
public final class MonitorNetworkConnectivityUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.demo.xxxvpn.domain.repository.AndroidSystemRepository androidSystemRepository = null;
    
    @javax.inject.Inject
    public MonitorNetworkConnectivityUseCase(@org.jetbrains.annotations.NotNull
    com.demo.xxxvpn.domain.repository.AndroidSystemRepository androidSystemRepository) {
        super();
    }
    
    /**
     * Invoke
     *
     * @return Flow of [NetworkState]
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.NetworkState> invoke() {
        return null;
    }
}