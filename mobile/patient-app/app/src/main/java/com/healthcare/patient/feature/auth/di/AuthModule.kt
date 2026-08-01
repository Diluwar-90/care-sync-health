package com.healthcare.patient.feature.auth.di

import com.healthcare.patient.feature.auth.data.datasource.FakeAuthDataSource
import com.healthcare.patient.feature.auth.data.repository.AuthRepositoryImpl
import com.healthcare.patient.feature.auth.domain.repository.AuthRepository
import com.healthcare.patient.feature.auth.domain.usecase.LoginUseCase
import com.healthcare.patient.feature.auth.domain.usecase.VerifyOtpUseCase
import com.healthcare.patient.feature.auth.presentation.viewmodel.LoginViewModel
import com.healthcare.patient.feature.auth.presentation.viewmodel.OtpViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authModule = module {

    single {
        FakeAuthDataSource()
    }

    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }

    factory {
        LoginUseCase(get())
    }

    factory {
        VerifyOtpUseCase(get())
    }

    viewModel {
        OtpViewModel(get(), get())
    }
    viewModel {
        LoginViewModel()
    }
}