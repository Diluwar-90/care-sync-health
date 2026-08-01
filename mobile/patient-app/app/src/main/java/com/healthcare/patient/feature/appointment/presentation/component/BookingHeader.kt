package com.healthcare.patient.feature.appointment.presentation.component


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun BookingHeader() {

    Column {

        Text(
            text = "Book Appointment",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Choose a date and available time slot."
        )

    }

}