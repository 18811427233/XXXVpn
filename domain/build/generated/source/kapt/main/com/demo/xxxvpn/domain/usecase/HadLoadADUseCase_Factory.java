package com.demo.xxxvpn.domain.usecase;

import com.demo.xxxvpn.domain.usecase.ad.GetAdShowRuleCanShowUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class HadLoadADUseCase_Factory implements Factory<HadLoadADUseCase> {
  private final Provider<GetAdShowRuleCanShowUseCase> ruleCanShowUseCaseProvider;

  public HadLoadADUseCase_Factory(
      Provider<GetAdShowRuleCanShowUseCase> ruleCanShowUseCaseProvider) {
    this.ruleCanShowUseCaseProvider = ruleCanShowUseCaseProvider;
  }

  @Override
  public HadLoadADUseCase get() {
    return newInstance(ruleCanShowUseCaseProvider.get());
  }

  public static HadLoadADUseCase_Factory create(
      Provider<GetAdShowRuleCanShowUseCase> ruleCanShowUseCaseProvider) {
    return new HadLoadADUseCase_Factory(ruleCanShowUseCaseProvider);
  }

  public static HadLoadADUseCase newInstance(GetAdShowRuleCanShowUseCase ruleCanShowUseCase) {
    return new HadLoadADUseCase(ruleCanShowUseCase);
  }
}
