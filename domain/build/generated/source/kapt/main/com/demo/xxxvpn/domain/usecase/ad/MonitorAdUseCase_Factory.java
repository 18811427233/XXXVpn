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
public final class MonitorAdUseCase_Factory implements Factory<MonitorAdUseCase> {
  private final Provider<ADRepository> adRepositoryProvider;

  private final Provider<CacheRepository> cacheRepositoryProvider;

  private final Provider<PreLoadAdUseCase> preLoadAdUseCaseProvider;

  public MonitorAdUseCase_Factory(Provider<ADRepository> adRepositoryProvider,
      Provider<CacheRepository> cacheRepositoryProvider,
      Provider<PreLoadAdUseCase> preLoadAdUseCaseProvider) {
    this.adRepositoryProvider = adRepositoryProvider;
    this.cacheRepositoryProvider = cacheRepositoryProvider;
    this.preLoadAdUseCaseProvider = preLoadAdUseCaseProvider;
  }

  @Override
  public MonitorAdUseCase get() {
    return newInstance(adRepositoryProvider.get(), cacheRepositoryProvider.get(), preLoadAdUseCaseProvider.get());
  }

  public static MonitorAdUseCase_Factory create(Provider<ADRepository> adRepositoryProvider,
      Provider<CacheRepository> cacheRepositoryProvider,
      Provider<PreLoadAdUseCase> preLoadAdUseCaseProvider) {
    return new MonitorAdUseCase_Factory(adRepositoryProvider, cacheRepositoryProvider, preLoadAdUseCaseProvider);
  }

  public static MonitorAdUseCase newInstance(ADRepository adRepository,
      CacheRepository cacheRepository, PreLoadAdUseCase preLoadAdUseCase) {
    return new MonitorAdUseCase(adRepository, cacheRepository, preLoadAdUseCase);
  }
}
