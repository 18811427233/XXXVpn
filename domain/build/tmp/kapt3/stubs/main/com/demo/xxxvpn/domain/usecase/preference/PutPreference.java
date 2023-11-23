package com.demo.xxxvpn.domain.usecase.preference;

/**
 * Put preference
 *
 * @param T preference type
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J%\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u00a6B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/preference/PutPreference;", "T", "", "invoke", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain"})
public abstract interface PutPreference<T extends java.lang.Object> {
    
    /**
     * Invoke
     * @param key name of the preference
     * @param value value to set
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object invoke(@org.jetbrains.annotations.Nullable
    java.lang.String key, @org.jetbrains.annotations.Nullable
    T value, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}