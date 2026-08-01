package com.healthcare.patient.feature.auth.domain.repository

interface AuthRepository {

    suspend fun login(
        phone: String
    ): Result<Unit>

    suspend fun verifyOtp(
        phone: String,
        otp: String
    ): Result<String>
}