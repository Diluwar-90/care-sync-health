package com.healthcare.patient.feature.splash.di

import com.healthcare.patient.feature.splash.presentation.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {

    viewModel {
        SplashViewModel(
            get(),
            get()
        )
    }

}