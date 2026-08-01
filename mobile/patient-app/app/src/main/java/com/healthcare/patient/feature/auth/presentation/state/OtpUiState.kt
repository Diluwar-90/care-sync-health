package com.healthcare.patient.feature.auth.presentation.state

data class OtpUiState(

    val otp: String = "",

    val isSuccess: Boolean = false

)