package com.healthcare.patient.feature.appointment.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun AppointmentInfoItem(

    title: String,

    value: String

) {

    Column(

        verticalArrangement = Arrangement.spacedBy(
            AppDimens.Space4
        )

    ) {

        Text(

            text = title,

            style = MaterialTheme.typography.labelMedium

        )

        Text(

            text = value,

            style = MaterialTheme.typography.bodyLarge,

            fontWeight = FontWeight.Medium

        )

    }

}