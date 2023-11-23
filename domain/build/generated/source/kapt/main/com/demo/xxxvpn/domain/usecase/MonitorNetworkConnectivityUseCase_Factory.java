package com.demo.xxxvpn.domain.usecase;

import com.demo.xxxvpn.domain.repository.AndroidSystemRepository;
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
public final class MonitorNetworkConnectivityUseCase_Factory implements Factory<MonitorNetworkConnectivityUseCase> {
  private final Provider<AndroidSystemRepository> androidSystemRepositoryProvider;

  public MonitorNetworkConnectivityUseCase_Factory(
      Provider<AndroidSystemRepository> androidSystemRepositoryProvider) {
    this.androidSystemRepositoryProvider = androidSystemRepositoryProvider;
  }

  @Override
  public MonitorNetworkConnectivityUseCase get() {
    return newInstance(androidSystemRepositoryProvider.get());
  }

  public static MonitorNetworkConnectivityUseCase_Factory create(
      Provider<AndroidSystemRepository> androidSystemRepositoryProvider) {
    return new MonitorNetworkConnectivityUseCase_Factory(androidSystemRepositoryProvider);
  }

  public static MonitorNetworkConnectivityUseCase newInstance(
      AndroidSystemRepository androidSystemRepository) {
    return new MonitorNetworkConnectivityUseCase(androidSystemRepository);
  }
}
