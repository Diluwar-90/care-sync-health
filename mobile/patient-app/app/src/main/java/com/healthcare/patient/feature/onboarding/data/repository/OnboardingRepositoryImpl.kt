package com.healthcare.patient.feature.onboarding.data.repository

import com.healthcare.patient.feature.onboarding.data.local.OnboardingLocalDataSource
import com.healthcare.patient.feature.onboarding.domain.repository.OnboardingRepository
import kotlinx.coroutines.flow.Flow

class OnboardingRepositoryImpl(
    private val localDataSource: OnboardingLocalDataSource
) : OnboardingRepository {

    override fun isCompleted(): Flow<Boolean> {
        return localDataSource.isCompleted()
    }

    override suspend fun complete() {
        localDataSource.complete()
    }
}