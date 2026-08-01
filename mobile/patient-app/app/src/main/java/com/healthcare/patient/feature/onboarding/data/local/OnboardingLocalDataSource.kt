package com.healthcare.patient.feature.onboarding.data.local

import com.healthcare.patient.core.datastore.PreferenceDataStore
import kotlinx.coroutines.flow.Flow

class OnboardingLocalDataSource(
    private val preferenceDataStore: PreferenceDataStore
) {

    fun isCompleted(): Flow<Boolean> =
        preferenceDataStore.onboardingCompleted

    suspend fun complete() =
        preferenceDataStore.completeOnboarding()

}