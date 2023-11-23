package com.demo.xxxvpn.domain.usecase.tunnel;

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
public final class MonitorSelectedRegionUseCase_Factory implements Factory<MonitorSelectedRegionUseCase> {
  private final Provider<CacheRepository> cacheRepositoryProvider;

  public MonitorSelectedRegionUseCase_Factory(Provider<CacheRepository> cacheRepositoryProvider) {
    this.cacheRepositoryProvider = cacheRepositoryProvider;
  }

  @Override
  public MonitorSelectedRegionUseCase get() {
    return newInstance(cacheRepositoryProvider.get());
  }

  public static MonitorSelectedRegionUseCase_Factory create(
      Provider<CacheRepository> cacheRepositoryProvider) {
    return new MonitorSelectedRegionUseCase_Factory(cacheRepositoryProvider);
  }

  public static MonitorSelectedRegionUseCase newInstance(CacheRepository cacheRepository) {
    return new MonitorSelectedRegionUseCase(cacheRepository);
  }
}
