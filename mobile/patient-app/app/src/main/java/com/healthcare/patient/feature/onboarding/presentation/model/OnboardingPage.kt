package com.healthcare.patient.feature.onboarding.presentation.model


import androidx.annotation.DrawableRes

data class OnboardingPage(

    @DrawableRes
    val image: Int,

    val title: String,

    val description: String

)