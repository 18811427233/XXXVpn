package com.demo.xxxvpn.domain.usecase.preference;

/**
 * Get preference
 *
 * @param T preference type
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u00a6\u0002\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/demo/xxxvpn/domain/usecase/preference/GetPreference;", "T", "", "invoke", "Lkotlinx/coroutines/flow/Flow;", "key", "", "default", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "domain"})
public abstract interface GetPreference<T extends java.lang.Object> {
    
    /**
     * Invoke
     * @param key name of the preference
     * @param default value to return if none set
     * @return current value of the preference and future updates as a flow
     */
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<T> invoke(@org.jetbrains.annotations.Nullable
    java.lang.String key, T p1_772401952);
}