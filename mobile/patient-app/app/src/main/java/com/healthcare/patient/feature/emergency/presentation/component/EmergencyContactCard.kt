package com.healthcare.patient.feature.emergency.presentation.component

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
import com.healthcare.patient.feature.emergency.presentation.model.EmergencyContact
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun EmergencyContactCard(

    contact: EmergencyContact,

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

                text = contact.name,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Text(
                text = "Relation : ${contact.relation}"
            )

            Text(
                text = "Phone : ${contact.phoneNumber}"
            )

        }

    }

}