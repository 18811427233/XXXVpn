package com.demo.xxxvpn.domain.usecase.ad;

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
public final class MonitorAdEventUseCase_Factory implements Factory<MonitorAdEventUseCase> {
  private final Provider<CacheRepository> cacheRepositoryProvider;

  public MonitorAdEventUseCase_Factory(Provider<CacheRepository> cacheRepositoryProvider) {
    this.cacheRepositoryProvider = cacheRepositoryProvider;
  }

  @Override
  public MonitorAdEventUseCase get() {
    return newInstance(cacheRepositoryProvider.get());
  }

  public static MonitorAdEventUseCase_Factory create(
      Provider<CacheRepository> cacheRepositoryProvider) {
    return new MonitorAdEventUseCase_Factory(cacheRepositoryProvider);
  }

  public static MonitorAdEventUseCase newInstance(CacheRepository cacheRepository) {
    return new MonitorAdEventUseCase(cacheRepository);
  }
}
