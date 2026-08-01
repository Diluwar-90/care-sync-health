package com.healthcare.patient.feature.appointment.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.appointment.presentation.component.BookingHeader
import com.healthcare.patient.feature.appointment.presentation.component.DateSection
import com.healthcare.patient.feature.appointment.presentation.component.TimeSection
import com.healthcare.patient.feature.appointment.presentation.viewmodel.AppointmentViewModel
import com.healthcare.patient.ui.component.PrimaryButton
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookingScreen(
    onBookingSuccess: () -> Unit,
    viewModel: AppointmentViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(AppDimens.ScreenPadding),
        verticalArrangement = Arrangement.spacedBy(AppDimens.Space24)
    ) {

        BookingHeader()

        DateSection(
            selectedDate = uiState.selectedDate,
            onDateSelected = viewModel::onDateSelected
        )

        TimeSection(
            selectedTime = uiState.selectedTime,
            onTimeSelected = viewModel::onTimeSelected
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Continue",
            onClick = onBookingSuccess
        )

    }

}