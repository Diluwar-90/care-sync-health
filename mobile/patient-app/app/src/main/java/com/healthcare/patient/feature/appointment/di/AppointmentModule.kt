package com.healthcare.patient.feature.appointment.di

import com.healthcare.patient.feature.appointment.presentation.viewmodel.AppointmentViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appointmentModule = module {

    viewModel {
        AppointmentViewModel()
    }

}