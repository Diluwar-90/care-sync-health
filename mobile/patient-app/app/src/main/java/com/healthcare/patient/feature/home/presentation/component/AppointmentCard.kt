package com.healthcare.patient.feature.home.presentation.component

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
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun AppointmentCard() {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(AppDimens.ContentPadding),
            verticalArrangement = Arrangement.spacedBy(AppDimens.Space8)
        ) {

            Text(
                text = "Upcoming Appointment",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Dr. Sarah Johnson",
                style = MaterialTheme.typography.titleSmall
            )

            Text(
                text = "Tomorrow • 10:30 AM"
            )

            Text(
                text = "Apollo Hospital"
            )

        }

    }

}