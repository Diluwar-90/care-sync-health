package com.healthcare.patient.feature.home.di

import com.healthcare.patient.feature.home.presentation.viewmodel.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    viewModel {
        HomeViewModel()
    }

}