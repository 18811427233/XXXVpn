package com.demo.xxxvpn.domain.usecase.ad;

import com.demo.xxxvpn.domain.repository.ADRepository;
import com.demo.xxxvpn.domain.repository.CacheRepository;
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
public final class ShowAdUseCase_Factory implements Factory<ShowAdUseCase> {
  private final Provider<ADRepository> adRepositoryProvider;

  private final Provider<CacheRepository> cacheRepositoryProvider;

  private final Provider<GetAdShowRuleCanShowUseCase> getAdShowRuleCanShowUseCaseProvider;

  public ShowAdUseCase_Factory(Provider<ADRepository> adRepositoryProvider,
      Provider<CacheRepository> cacheRepositoryProvider,
      Provider<GetAdShowRuleCanShowUseCase> getAdShowRuleCanShowUseCaseProvider) {
    this.adRepositoryProvider = adRepositoryProvider;
    this.cacheRepositoryProvider = cacheRepositoryProvider;
    this.getAdShowRuleCanShowUseCaseProvider = getAdShowRuleCanShowUseCaseProvider;
  }

  @Override
  public ShowAdUseCase get() {
    return newInstance(adRepositoryProvider.get(), cacheRepositoryProvider.get(), getAdShowRuleCanShowUseCaseProvider.get());
  }

  public static ShowAdUseCase_Factory create(Provider<ADRepository> adRepositoryProvider,
      Provider<CacheRepository> cacheRepositoryProvider,
      Provider<GetAdShowRuleCanShowUseCase> getAdShowRuleCanShowUseCaseProvider) {
    return new ShowAdUseCase_Factory(adRepositoryProvider, cacheRepositoryProvider, getAdShowRuleCanShowUseCaseProvider);
  }

  public static ShowAdUseCase newInstance(ADRepository adRepository,
      CacheRepository cacheRepository, GetAdShowRuleCanShowUseCase getAdShowRuleCanShowUseCase) {
    return new ShowAdUseCase(adRepository, cacheRepository, getAdShowRuleCanShowUseCase);
  }
}
