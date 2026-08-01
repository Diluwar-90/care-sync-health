package com.healthcare.patient.feature.appointment.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.healthcare.patient.feature.appointment.presentation.component.AppointmentInfoItem
import com.healthcare.patient.ui.component.AppToolbar
import com.healthcare.patient.ui.component.PrimaryButton
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun AppointmentDetailsScreen(

    onBackClick: () -> Unit,

    onCancelAppointment: () -> Unit

) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()

    ) {

        AppToolbar(

            title = "Appointment Details",

            showBackButton = true,

            onBackClick = onBackClick

        )

        Column(

            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(
                    AppDimens.ScreenPadding
                ),

            verticalArrangement = Arrangement.spacedBy(
                AppDimens.Space16
            )

        ) {

            AppointmentInfoItem(

                title = "Doctor",

                value = "Dr. Ahmed Khan"
            )

            AppointmentInfoItem(

                title = "Specialization",

                value = "Cardiologist"
            )

            AppointmentInfoItem(

                title = "Hospital",

                value = "Apollo Hospital"
            )

            AppointmentInfoItem(

                title = "Date",

                value = "15 Jul 2026"
            )

            AppointmentInfoItem(

                title = "Time",

                value = "10:30 AM"
            )

            AppointmentInfoItem(

                title = "Status",

                value = "Confirmed"
            )

            AppointmentInfoItem(

                title = "Consultation Fee",

                value = "₹800"
            )

            AppointmentInfoItem(

                title = "Patient",

                value = "Diluwar Hossain"
            )

            AppointmentInfoItem(

                title = "Notes",

                value = "Please arrive 15 minutes early."
            )

            PrimaryButton(

                text = "Cancel Appointment",

                onClick = onCancelAppointment

            )

        }

    }

}