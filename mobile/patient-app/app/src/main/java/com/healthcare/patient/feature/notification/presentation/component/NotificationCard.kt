package com.healthcare.patient.feature.notification.presentation.component

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
import com.healthcare.patient.feature.notification.presentation.model.NotificationItem
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun NotificationCard(

    notification: NotificationItem,

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

                text = notification.title,

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Text(

                text = notification.description,

                style = MaterialTheme.typography.bodyMedium

            )

            Text(

                text = notification.time,

                style = MaterialTheme.typography.bodySmall

            )

        }

    }

}