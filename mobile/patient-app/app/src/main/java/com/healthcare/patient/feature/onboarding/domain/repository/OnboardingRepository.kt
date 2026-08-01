package com.healthcare.patient.feature.onboarding.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnboardingRepository {

    fun isCompleted(): Flow<Boolean>

    suspend fun complete()

}