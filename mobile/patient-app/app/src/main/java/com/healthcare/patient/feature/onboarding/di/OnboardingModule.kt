package com.healthcare.patient.feature.onboarding.di


import com.healthcare.patient.feature.onboarding.data.local.OnboardingLocalDataSource
import com.healthcare.patient.feature.onboarding.data.repository.OnboardingRepositoryImpl
import com.healthcare.patient.feature.onboarding.domain.repository.OnboardingRepository
import com.healthcare.patient.feature.onboarding.domain.usecase.CompleteOnboardingUseCase
import com.healthcare.patient.feature.onboarding.domain.usecase.GetOnboardingStatusUseCase
import com.healthcare.patient.feature.onboarding.presentation.viewmodel.OnboardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {

    single {
        OnboardingLocalDataSource(get())
    }

    single<OnboardingRepository> {
        OnboardingRepositoryImpl(get())
    }

    factory {
        GetOnboardingStatusUseCase(get())
    }

    factory {
        CompleteOnboardingUseCase(get())
    }

    viewModel {
        OnboardingViewModel(get())
    }

}