package com.healthcare.patient.feature.ai.di

import com.healthcare.patient.feature.ai.presentation.viewmodel.AiViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val aiModule = module {

    viewModel {

        AiViewModel()

    }

}