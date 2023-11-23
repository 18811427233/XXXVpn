package com.demo.xxxvpn.domain.usecase.tunnel;

import com.demo.xxxvpn.domain.repository.TunnelRepository;
import com.demo.xxxvpn.domain.usecase.MonitorNetworkConnectivityUseCase;
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
public final class MonitorConnectStateUseCase_Factory implements Factory<MonitorConnectStateUseCase> {
  private final Provider<MonitorTunnelStateUseCase> monitorTunnelStateUseCaseProvider;

  private final Provider<MonitorNetworkConnectivityUseCase> monitorNetworkConnectivityUseCaseProvider;

  private final Provider<MonitorSelectedRegionUseCase> monitorSelectedRegionUseCaseProvider;

  private final Provider<SaveLastConnectedTimestampUseCase> saveLastConnectedTimestampUseCaseProvider;

  private final Provider<TunnelRepository> tunnelRepositoryProvider;

  public MonitorConnectStateUseCase_Factory(
      Provider<MonitorTunnelStateUseCase> monitorTunnelStateUseCaseProvider,
      Provider<MonitorNetworkConnectivityUseCase> monitorNetworkConnectivityUseCaseProvider,
      Provider<MonitorSelectedRegionUseCase> monitorSelectedRegionUseCaseProvider,
      Provider<SaveLastConnectedTimestampUseCase> saveLastConnectedTimestampUseCaseProvider,
      Provider<TunnelRepository> tunnelRepositoryProvider) {
    this.monitorTunnelStateUseCaseProvider = monitorTunnelStateUseCaseProvider;
    this.monitorNetworkConnectivityUseCaseProvider = monitorNetworkConnectivityUseCaseProvider;
    this.monitorSelectedRegionUseCaseProvider = monitorSelectedRegionUseCaseProvider;
    this.saveLastConnectedTimestampUseCaseProvider = saveLastConnectedTimestampUseCaseProvider;
    this.tunnelRepositoryProvider = tunnelRepositoryProvider;
  }

  @Override
  public MonitorConnectStateUseCase get() {
    return newInstance(monitorTunnelStateUseCaseProvider.get(), monitorNetworkConnectivityUseCaseProvider.get(), monitorSelectedRegionUseCaseProvider.get(), saveLastConnectedTimestampUseCaseProvider.get(), tunnelRepositoryProvider.get());
  }

  public static MonitorConnectStateUseCase_Factory create(
      Provider<MonitorTunnelStateUseCase> monitorTunnelStateUseCaseProvider,
      Provider<MonitorNetworkConnectivityUseCase> monitorNetworkConnectivityUseCaseProvider,
      Provider<MonitorSelectedRegionUseCase> monitorSelectedRegionUseCaseProvider,
      Provider<SaveLastConnectedTimestampUseCase> saveLastConnectedTimestampUseCaseProvider,
      Provider<TunnelRepository> tunnelRepositoryProvider) {
    return new MonitorConnectStateUseCase_Factory(monitorTunnelStateUseCaseProvider, monitorNetworkConnectivityUseCaseProvider, monitorSelectedRegionUseCaseProvider, saveLastConnectedTimestampUseCaseProvider, tunnelRepositoryProvider);
  }

  public static MonitorConnectStateUseCase newInstance(
      MonitorTunnelStateUseCase monitorTunnelStateUseCase,
      MonitorNetworkConnectivityUseCase monitorNetworkConnectivityUseCase,
      MonitorSelectedRegionUseCase monitorSelectedRegionUseCase,
      SaveLastConnectedTimestampUseCase saveLastConnectedTimestampUseCase,
      TunnelRepository tunnelRepository) {
    return new MonitorConnectStateUseCase(monitorTunnelStateUseCase, monitorNetworkConnectivityUseCase, monitorSelectedRegionUseCase, saveLastConnectedTimestampUseCase, tunnelRepository);
  }
}
