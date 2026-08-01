package com.healthcare.patient.feature.splash.presentation.state

data class SplashUiState(

    val isLoading: Boolean = true,

    val isOnboardingCompleted: Boolean? = null,

    val isLoggedIn: Boolean? = null

)