package com.healthcare.patient.feature.appointment.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.healthcare.patient.feature.appointment.presentation.model.Appointment
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun AppointmentCard(
    appointment: Appointment,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {

        Column(
            modifier = Modifier.padding(AppDimens.ContentPadding),
            verticalArrangement = Arrangement.spacedBy(AppDimens.Space8)
        ) {

            Text(
                text = appointment.doctorName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(appointment.specialization)

            Text(appointment.hospital)

            Text("${appointment.date} • ${appointment.time}")

            Text(
                text = appointment.status.name
            )

        }

    }

}