package com.demo.xxxvpn.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/demo/xxxvpn/domain/repository/AndroidSystemRepository;", "", "getNetworkState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/demo/xxxvpn/domain/entity/NetworkState;", "getGetNetworkState", "()Lkotlinx/coroutines/flow/Flow;", "copyTextToClipboard", "", "label", "", "text", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doesFileExist", "", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain"})
public abstract interface AndroidSystemRepository {
    
    /**
     * Monitor network connectivity to check whether device is connected to the internet
     *
     * @see NetworkState
     */
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.demo.xxxvpn.domain.entity.NetworkState> getGetNetworkState();
    
    /**
     * Copy text to primary clipboard
     *
     * @param label the clipboard label as [String]
     * @param text the text to copy to clipboard as [String]
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object copyTextToClipboard(@org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String text, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object doesFileExist(@org.jetbrains.annotations.Nullable
    java.lang.String path, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}