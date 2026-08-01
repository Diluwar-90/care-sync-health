package com.healthcare.patient.feature.profile.di

import com.healthcare.patient.feature.profile.presentation.viewmodel.ProfileViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {

    viewModel {

        ProfileViewModel()

    }

}