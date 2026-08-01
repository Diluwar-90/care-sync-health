package com.healthcare.patient.feature.medicalrecord.di

import com.healthcare.patient.feature.medicalrecord.presentation.viewmodel.MedicalRecordViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val medicalModule = module {

    viewModel {

        MedicalRecordViewModel()

    }

}