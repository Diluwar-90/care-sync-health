package com.healthcare.patient.feature.splash.presentation.state

sealed interface SplashDestination {

    data object Onboarding : SplashDestination

    data object Login : SplashDestination

}