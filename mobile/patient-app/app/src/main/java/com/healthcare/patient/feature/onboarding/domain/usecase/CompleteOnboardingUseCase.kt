package com.healthcare.patient.feature.onboarding.domain.usecase

import com.healthcare.patient.feature.onboarding.domain.repository.OnboardingRepository

class CompleteOnboardingUseCase(
    private val repository: OnboardingRepository
) {

    suspend operator fun invoke() {
        repository.complete()
    }

}