package com.healthcare.patient.feature.emergency.di

import com.healthcare.patient.feature.emergency.presentation.viewmodel.EmergencyViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val emergencyModule = module {

    viewModel {

        EmergencyViewModel()

    }

}