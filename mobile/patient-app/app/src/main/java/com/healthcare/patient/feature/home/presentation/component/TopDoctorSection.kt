package com.healthcare.patient.feature.home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun TopDoctorSection() {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(AppDimens.Space16)
    ) {

        Text(
            text = "Top Doctors",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        DoctorCard(
            name = "Dr. Ahmed Khan",
            specialization = "Cardiologist",
            rating = "4.9",
            onClick = {}
        )

        DoctorCard(
            name = "Dr. Priya Sharma",
            specialization = "Dentist",
            rating = "4.8",
            onClick = {}
        )

        DoctorCard(
            name = "Dr. David Wilson",
            specialization = "Neurologist",
            rating = "4.7",
            onClick = {}
        )

    }

}