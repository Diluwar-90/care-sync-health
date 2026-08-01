package com.healthcare.patient.feature.appointment.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.appointment.presentation.component.AppointmentCard
import com.healthcare.patient.feature.appointment.presentation.component.AppointmentTabSection
import com.healthcare.patient.feature.appointment.presentation.viewmodel.AppointmentViewModel
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyAppointmentsScreen(
    onNavigateToAppointmentDetails: () -> Unit,
    viewModel: AppointmentViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),
        contentPadding = PaddingValues(AppDimens.ScreenPadding),
        verticalArrangement = Arrangement.spacedBy(AppDimens.Space16)
    ) {

        item {

            AppointmentTabSection(
                selectedTab = uiState.selectedTab,
                onTabSelected = viewModel::onTabChanged
            )

        }

        items(
            uiState.appointments.filter {
                it.status == uiState.selectedTab
            }
        ) { appointment ->

            AppointmentCard(
                appointment = appointment,
                onClick = {
                    onNavigateToAppointmentDetails()
                }
            )

        }

    }

}