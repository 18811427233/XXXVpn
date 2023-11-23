package com.demo.xxxvpn.domain.usecase;

import com.demo.xxxvpn.domain.repository.TunnelRepository;
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
public final class MonitorDeviceIdUseCase_Factory implements Factory<MonitorDeviceIdUseCase> {
  private final Provider<TunnelRepository> repositoryProvider;

  public MonitorDeviceIdUseCase_Factory(Provider<TunnelRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MonitorDeviceIdUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static MonitorDeviceIdUseCase_Factory create(
      Provider<TunnelRepository> repositoryProvider) {
    return new MonitorDeviceIdUseCase_Factory(repositoryProvider);
  }

  public static MonitorDeviceIdUseCase newInstance(TunnelRepository repository) {
    return new MonitorDeviceIdUseCase(repository);
  }
}
