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
public final class ResetLastConnectedTimestampUseCase_Factory implements Factory<ResetLastConnectedTimestampUseCase> {
  private final Provider<CacheRepository> cacheRepositoryProvider;

  public ResetLastConnectedTimestampUseCase_Factory(
      Provider<CacheRepository> cacheRepositoryProvider) {
    this.cacheRepositoryProvider = cacheRepositoryProvider;
  }

  @Override
  public ResetLastConnectedTimestampUseCase get() {
    return newInstance(cacheRepositoryProvider.get());
  }

  public static ResetLastConnectedTimestampUseCase_Factory create(
      Provider<CacheRepository> cacheRepositoryProvider) {
    return new ResetLastConnectedTimestampUseCase_Factory(cacheRepositoryProvider);
  }

  public static ResetLastConnectedTimestampUseCase newInstance(CacheRepository cacheRepository) {
    return new ResetLastConnectedTimestampUseCase(cacheRepository);
  }
}
