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
public final class ConnectTunnelUseCase_Factory implements Factory<ConnectTunnelUseCase> {
  private final Provider<TunnelRepository> tunnelRepositoryProvider;

  public ConnectTunnelUseCase_Factory(Provider<TunnelRepository> tunnelRepositoryProvider) {
    this.tunnelRepositoryProvider = tunnelRepositoryProvider;
  }

  @Override
  public ConnectTunnelUseCase get() {
    return newInstance(tunnelRepositoryProvider.get());
  }

  public static ConnectTunnelUseCase_Factory create(
      Provider<TunnelRepository> tunnelRepositoryProvider) {
    return new ConnectTunnelUseCase_Factory(tunnelRepositoryProvider);
  }

  public static ConnectTunnelUseCase newInstance(TunnelRepository tunnelRepository) {
    return new ConnectTunnelUseCase(tunnelRepository);
  }
}
