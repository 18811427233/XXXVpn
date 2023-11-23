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
public final class DisconnectTunnelUseCase_Factory implements Factory<DisconnectTunnelUseCase> {
  private final Provider<TunnelRepository> tunnelRepositoryProvider;

  private final Provider<ResetLastConnectedTimestampUseCase> resetLastConnectedTimestampUseCaseProvider;

  public DisconnectTunnelUseCase_Factory(Provider<TunnelRepository> tunnelRepositoryProvider,
      Provider<ResetLastConnectedTimestampUseCase> resetLastConnectedTimestampUseCaseProvider) {
    this.tunnelRepositoryProvider = tunnelRepositoryProvider;
    this.resetLastConnectedTimestampUseCaseProvider = resetLastConnectedTimestampUseCaseProvider;
  }

  @Override
  public DisconnectTunnelUseCase get() {
    return newInstance(tunnelRepositoryProvider.get(), resetLastConnectedTimestampUseCaseProvider.get());
  }

  public static DisconnectTunnelUseCase_Factory create(
      Provider<TunnelRepository> tunnelRepositoryProvider,
      Provider<ResetLastConnectedTimestampUseCase> resetLastConnectedTimestampUseCaseProvider) {
    return new DisconnectTunnelUseCase_Factory(tunnelRepositoryProvider, resetLastConnectedTimestampUseCaseProvider);
  }

  public static DisconnectTunnelUseCase newInstance(TunnelRepository tunnelRepository,
      ResetLastConnectedTimestampUseCase resetLastConnectedTimestampUseCase) {
    return new DisconnectTunnelUseCase(tunnelRepository, resetLastConnectedTimestampUseCase);
  }
}
