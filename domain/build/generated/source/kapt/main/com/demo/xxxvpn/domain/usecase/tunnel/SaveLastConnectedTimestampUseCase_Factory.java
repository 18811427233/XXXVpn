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
public final class SaveLastConnectedTimestampUseCase_Factory implements Factory<SaveLastConnectedTimestampUseCase> {
  private final Provider<CacheRepository> cacheRepositoryProvider;

  public SaveLastConnectedTimestampUseCase_Factory(
      Provider<CacheRepository> cacheRepositoryProvider) {
    this.cacheRepositoryProvider = cacheRepositoryProvider;
  }

  @Override
  public SaveLastConnectedTimestampUseCase get() {
    return newInstance(cacheRepositoryProvider.get());
  }

  public static SaveLastConnectedTimestampUseCase_Factory create(
      Provider<CacheRepository> cacheRepositoryProvider) {
    return new SaveLastConnectedTimestampUseCase_Factory(cacheRepositoryProvider);
  }

  public static SaveLastConnectedTimestampUseCase newInstance(CacheRepository cacheRepository) {
    return new SaveLastConnectedTimestampUseCase(cacheRepository);
  }
}
