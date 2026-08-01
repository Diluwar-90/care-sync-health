package com.healthcare.patient.feature.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MedicineReminderSection() {

    Column {

        Text(
            text = "Today's Medicines",
            style = MaterialTheme.typography.titleLarge
        )

        Text("Paracetamol • 08:00 AM")

        Text("Vitamin D • 09:00 PM")

    }

}