package com.healthcare.patient.feature.auth.domain.usecase


import com.healthcare.patient.feature.auth.domain.repository.AuthRepository

class VerifyOtpUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        phone: String,
        otp: String
    ) = repository.verifyOtp(phone, otp)

}