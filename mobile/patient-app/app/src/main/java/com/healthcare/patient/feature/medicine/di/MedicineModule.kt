package com.healthcare.patient.feature.medicine.di

import com.healthcare.patient.feature.medicine.presentation.viewmodel.MedicineReminderViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val medicineModule = module {

    viewModel {

        MedicineReminderViewModel()

    }

}