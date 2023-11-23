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
public final class GetAdShowRuleCanShowUseCase_Factory implements Factory<GetAdShowRuleCanShowUseCase> {
  private final Provider<CacheRepository> cacheRepositoryProvider;

  private final Provider<ADRepository> adRepositoryProvider;

  public GetAdShowRuleCanShowUseCase_Factory(Provider<CacheRepository> cacheRepositoryProvider,
      Provider<ADRepository> adRepositoryProvider) {
    this.cacheRepositoryProvider = cacheRepositoryProvider;
    this.adRepositoryProvider = adRepositoryProvider;
  }

  @Override
  public GetAdShowRuleCanShowUseCase get() {
    return newInstance(cacheRepositoryProvider.get(), adRepositoryProvider.get());
  }

  public static GetAdShowRuleCanShowUseCase_Factory create(
      Provider<CacheRepository> cacheRepositoryProvider,
      Provider<ADRepository> adRepositoryProvider) {
    return new GetAdShowRuleCanShowUseCase_Factory(cacheRepositoryProvider, adRepositoryProvider);
  }

  public static GetAdShowRuleCanShowUseCase newInstance(CacheRepository cacheRepository,
      ADRepository adRepository) {
    return new GetAdShowRuleCanShowUseCase(cacheRepository, adRepository);
  }
}
