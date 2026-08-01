package com.healthcare.patient.feature.medicalrecord.presentation.component

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
import com.healthcare.patient.feature.medicalrecord.presentation.model.MedicalRecord
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun MedicalRecordCard(

    record: MedicalRecord,

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

                text = record.title,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Text(
                text = record.category
            )

            Text(
                text = record.hospital
            )

            Text(
                text = record.date
            )

        }

    }

}