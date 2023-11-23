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
public final class MonitorCurrentConnectedTimestampUseCase_Factory implements Factory<MonitorCurrentConnectedTimestampUseCase> {
  private final Provider<CacheRepository> cacheRepositoryProvider;

  public MonitorCurrentConnectedTimestampUseCase_Factory(
      Provider<CacheRepository> cacheRepositoryProvider) {
    this.cacheRepositoryProvider = cacheRepositoryProvider;
  }

  @Override
  public MonitorCurrentConnectedTimestampUseCase get() {
    return newInstance(cacheRepositoryProvider.get());
  }

  public static MonitorCurrentConnectedTimestampUseCase_Factory create(
      Provider<CacheRepository> cacheRepositoryProvider) {
    return new MonitorCurrentConnectedTimestampUseCase_Factory(cacheRepositoryProvider);
  }

  public static MonitorCurrentConnectedTimestampUseCase newInstance(
      CacheRepository cacheRepository) {
    return new MonitorCurrentConnectedTimestampUseCase(cacheRepository);
  }
}
