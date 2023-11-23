package com.demo.xxxvpn.domain.usecase.tunnel;

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
public final class MonitorTunnelStateUseCase_Factory implements Factory<MonitorTunnelStateUseCase> {
  private final Provider<TunnelRepository> tunnelRepositoryProvider;

  private final Provider<ResetLastConnectedTimestampUseCase> resetLastConnectedTimestampUseCaseProvider;

  public MonitorTunnelStateUseCase_Factory(Provider<TunnelRepository> tunnelRepositoryProvider,
      Provider<ResetLastConnectedTimestampUseCase> resetLastConnectedTimestampUseCaseProvider) {
    this.tunnelRepositoryProvider = tunnelRepositoryProvider;
    this.resetLastConnectedTimestampUseCaseProvider = resetLastConnectedTimestampUseCaseProvider;
  }

  @Override
  public MonitorTunnelStateUseCase get() {
    return newInstance(tunnelRepositoryProvider.get(), resetLastConnectedTimestampUseCaseProvider.get());
  }

  public static MonitorTunnelStateUseCase_Factory create(
      Provider<TunnelRepository> tunnelRepositoryProvider,
      Provider<ResetLastConnectedTimestampUseCase> resetLastConnectedTimestampUseCaseProvider) {
    return new MonitorTunnelStateUseCase_Factory(tunnelRepositoryProvider, resetLastConnectedTimestampUseCaseProvider);
  }

  public static MonitorTunnelStateUseCase newInstance(TunnelRepository tunnelRepository,
      ResetLastConnectedTimestampUseCase resetLastConnectedTimestampUseCase) {
    return new MonitorTunnelStateUseCase(tunnelRepository, resetLastConnectedTimestampUseCase);
  }
}
