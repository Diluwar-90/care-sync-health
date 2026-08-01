package com.healthcare.patient.feature.onboarding.presentation.model

import com.healthcare.patient.R

object OnboardingData {

    val pages = listOf(

        OnboardingPage(
            image = R.drawable.ic_onboarding_doctor,
            title = "Book Appointments",
            description = "Find experienced doctors and book appointments anytime, anywhere."
        ),

        OnboardingPage(
            image = R.drawable.ic_onboarding_records,
            title = "Manage Medical Records",
            description = "Securely store prescriptions, lab reports, and your complete medical history."
        ),

        OnboardingPage(
            image = R.drawable.ic_onboarding_ai,
            title = "AI Health Assistant",
            description = "Get intelligent health guidance, reminders, and personalized insights."
        )

    )

}