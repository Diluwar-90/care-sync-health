package com.healthcare.patient.feature.home.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun DoctorCard(
    name: String,
    specialization: String,
    rating: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {

        Column(
            modifier = Modifier.padding(AppDimens.ContentPadding),
            verticalArrangement = Arrangement.spacedBy(AppDimens.Space8)
        ) {

            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = specialization,
                style = MaterialTheme.typography.bodyMedium
            )

            Row {

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )

                Text(
                    text = " $rating"
                )

            }

        }

    }

}