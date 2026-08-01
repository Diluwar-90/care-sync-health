package com.healthcare.patient.feature.notification.di

import com.healthcare.patient.feature.notification.presentation.viewmodel.NotificationViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val notificationModule = module {

    viewModel {

        NotificationViewModel()

    }

}