package com.healthcare.patient.feature.auth.data.repository

import com.healthcare.patient.feature.auth.data.datasource.FakeAuthDataSource
import com.healthcare.patient.feature.auth.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val dataSource: FakeAuthDataSource
) : AuthRepository {

    override suspend fun login(
        phone: String
    ): Result<Unit> {

        dataSource.login(phone)

        return Result.success(Unit)
    }

    override suspend fun verifyOtp(
        phone: String,
        otp: String
    ): Result<String> {

        return Result.success(
            dataSource.verifyOtp(phone, otp)
        )
    }
}