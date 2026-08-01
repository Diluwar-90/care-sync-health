package com.healthcare.patient.feature.family.di

import com.healthcare.patient.feature.family.presentation.viewmodel.FamilyViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val familyModule = module {

    viewModel {

        FamilyViewModel()

    }

}