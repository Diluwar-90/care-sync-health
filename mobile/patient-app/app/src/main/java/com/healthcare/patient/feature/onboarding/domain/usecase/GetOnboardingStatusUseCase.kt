package com.healthcare.patient.feature.onboarding.domain.usecase

import com.healthcare.patient.feature.onboarding.domain.repository.OnboardingRepository
import kotlinx.coroutines.flow.Flow

class GetOnboardingStatusUseCase(
    private val repository: OnboardingRepository
) {

    operator fun invoke(): Flow<Boolean> {
        return repository.isCompleted()
    }

}