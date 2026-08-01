package com.healthcare.patient.core.di

import com.healthcare.patient.core.datastore.PreferenceDataStore
import com.healthcare.patient.feature.ai.di.aiModule
import com.healthcare.patient.feature.appointment.di.appointmentModule
import com.healthcare.patient.feature.auth.di.authModule
import com.healthcare.patient.feature.doctor.di.doctorModule
import com.healthcare.patient.feature.emergency.di.emergencyModule
import com.healthcare.patient.feature.family.di.familyModule
import com.healthcare.patient.feature.home.di.homeModule
import com.healthcare.patient.feature.medicalrecord.di.medicalModule
import com.healthcare.patient.feature.medicine.di.medicineModule
import com.healthcare.patient.feature.notification.di.notificationModule
import com.healthcare.patient.feature.onboarding.di.onboardingModule
import com.healthcare.patient.feature.profile.di.profileModule
import com.healthcare.patient.feature.settings.di.settingsModule
import com.healthcare.patient.feature.splash.di.splashModule
import org.koin.dsl.module


val appModules = listOf(
    splashModule,
    onboardingModule,
    homeModule,
    authModule,
    doctorModule,
    appointmentModule,
    medicalModule,
    aiModule,
    notificationModule,
    profileModule,
    settingsModule,
    familyModule,
    emergencyModule,
    medicineModule,

    module {

        single {

            PreferenceDataStore(
                get()
            )

        }
    }

)