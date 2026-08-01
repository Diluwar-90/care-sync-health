package com.healthcare.patient.feature.auth.domain.usecase

import com.healthcare.patient.feature.auth.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        phone: String
    ) = repository.login(phone)

}