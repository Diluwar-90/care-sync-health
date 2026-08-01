package com.healthcare.patient.feature.home.presentation.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun HomeTopBar(

    userName: String,

    onNotificationClick: () -> Unit,

    onProfileClick: () -> Unit

) {

    Row(

        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceBetween,

        verticalAlignment = Alignment.CenterVertically

    ) {

        Column {

            Text(

                text = "👋 Good Morning",

                style = MaterialTheme.typography.titleMedium

            )

            Text(

                text = userName,

                style = MaterialTheme.typography.headlineSmall,

                fontWeight = FontWeight.Bold

            )

        }

        Row {

            IconButton(

                onClick = onNotificationClick

            ) {

                Icon(

                    imageVector = Icons.Default.Notifications,

                    contentDescription = "Notifications"

                )

            }

            IconButton(

                onClick = onProfileClick

            ) {

                Icon(

                    imageVector = Icons.Default.Person,

                    contentDescription = "Profile"

                )

            }

        }

    }

}