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
fun DateSection(
    selectedDate: String,
    onDateSelected: (String) -> Unit
) {

    val dates = listOf(
        "Today",
        "Tomorrow",
        "Fri",
        "Sat",
        "Sun"
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Select Date",
            style = MaterialTheme.typography.titleMedium
        )

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            dates.forEach { date ->

                AssistChip(
                    onClick = {
                        onDateSelected(date)
                    },
                    label = {
                        Text(date)
                    },
                    colors =
                        if (selectedDate == date) {
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