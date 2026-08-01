package com.healthcare.patient.feature.auth.data.datasource

import kotlinx.coroutines.delay

class FakeAuthDataSource {

    suspend fun login(phone: String) {
        delay(1500)
    }

    suspend fun verifyOtp(
        phone: String,
        otp: String
    ): String {

        delay(1500)

        return "dummy_jwt_token"
    }
}