package com.demo.xxxvpn.domain.usecase;

import com.demo.xxxvpn.domain.repository.ADRepository;
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
public final class IsAdLoadUseCase_Factory implements Factory<IsAdLoadUseCase> {
  private final Provider<ADRepository> adRepositoryProvider;

  public IsAdLoadUseCase_Factory(Provider<ADRepository> adRepositoryProvider) {
    this.adRepositoryProvider = adRepositoryProvider;
  }

  @Override
  public IsAdLoadUseCase get() {
    return newInstance(adRepositoryProvider.get());
  }

  public static IsAdLoadUseCase_Factory create(Provider<ADRepository> adRepositoryProvider) {
    return new IsAdLoadUseCase_Factory(adRepositoryProvider);
  }

  public static IsAdLoadUseCase newInstance(ADRepository adRepository) {
    return new IsAdLoadUseCase(adRepository);
  }
}
