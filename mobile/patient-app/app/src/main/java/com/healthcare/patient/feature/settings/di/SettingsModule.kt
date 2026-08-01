package com.healthcare.patient.feature.settings.di

import com.healthcare.patient.feature.settings.presentation.viewmodel.SettingsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val settingsModule = module {

    viewModel {

        SettingsViewModel()

    }

}