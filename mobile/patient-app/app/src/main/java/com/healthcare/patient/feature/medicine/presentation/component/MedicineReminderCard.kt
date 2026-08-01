package com.healthcare.patient.feature.medicine.presentation.component

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
import com.healthcare.patient.feature.medicine.presentation.model.MedicineReminder
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun MedicineReminderCard(

    reminder: MedicineReminder,

    onClick: () -> Unit

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onClick()

            }

    ) {

        Column(

            modifier = Modifier.padding(
                AppDimens.ContentPadding
            ),

            verticalArrangement = Arrangement.spacedBy(
                AppDimens.Space8
            )

        ) {

            Text(

                text = reminder.medicineName,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Text(
                text = "Dosage : ${reminder.dosage}"
            )

            Text(
                text = "Time : ${reminder.time}"
            )

            Text(
                text = "Frequency : ${reminder.frequency}"
            )

            Text(
                text = if (reminder.isCompleted) {
                    "Status : Completed"
                } else {
                    "Status : Pending"
                }
            )

        }

    }

}