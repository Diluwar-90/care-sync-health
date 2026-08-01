package com.healthcare.patient.feature.appointment.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TimeSection(
    selectedTime: String,
    onTimeSelected: (String) -> Unit
) {

    val timeSlots = listOf(
        "09:00 AM",
        "09:30 AM",
        "10:00 AM",
        "10:30 AM",
        "11:00 AM",
        "11:30 AM",
        "12:00 PM",
        "12:30 PM"
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Available Time Slots",
            style = MaterialTheme.typography.titleMedium
        )

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            timeSlots.forEach { time ->

                AssistChip(
                    onClick = {
                        onTimeSelected(time)
                    },
                    label = {
                        Text(time)
                    },
                    colors =
                        if (selectedTime == time) {
                            AssistChipDefaults.assistChipColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                labelColor = MaterialTheme.colorScheme.onPrimary
                            )
                        } else {
                            AssistChipDefaults.assistChipColors()
                        }
                )

            }

        }

    }

}