package com.healthcare.patient.feature.doctor.di

import com.healthcare.patient.feature.doctor.presentation.viewmodel.DoctorDetailsViewModel
import com.healthcare.patient.feature.doctor.presentation.viewmodel.DoctorViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val doctorModule = module {

    viewModel {
        DoctorViewModel()
    }

    viewModel {
        DoctorDetailsViewModel()
    }

}