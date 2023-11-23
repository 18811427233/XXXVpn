package com.demo.xxxvpn.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/demo/xxxvpn/domain/repository/ADRepository;", "", "init", "", "isEveryTimeShow", "", "key", "", "isPageAdLoad", "adId", "loadPageAd", "monitorPageAd", "Lkotlinx/coroutines/flow/MutableStateFlow;", "notifyPageAdState", "load", "showEveryTime", "showPageAd", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain"})
public abstract interface ADRepository {
    
    public abstract void init();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> monitorPageAd(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String adId);
    
    public abstract void notifyPageAdState(@org.jetbrains.annotations.NotNull
    java.lang.String adId, boolean load);
    
    public abstract void loadPageAd(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String adId);
    
    public abstract boolean isPageAdLoad(@org.jetbrains.annotations.NotNull
    java.lang.String adId);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object showPageAd(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String adId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    public abstract boolean isEveryTimeShow(@org.jetbrains.annotations.NotNull
    java.lang.String key);
    
    public abstract void showEveryTime(@org.jetbrains.annotations.NotNull
    java.lang.String key);
}