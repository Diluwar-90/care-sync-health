package com.healthcare.patient.feature.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RecentMedicalRecordSection() {

    Column {

        Text(
            text = "Recent Medical Records",
            style = MaterialTheme.typography.titleLarge
        )

        Text("Blood Test Report")

        Text("Heart Prescription")

    }

}