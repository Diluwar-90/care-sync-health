package com.healthcare.patient.feature.profile.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun ProfileMenuItem(

    title: String,

    onClick: () -> Unit

) {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onClick()

            }
            .padding(AppDimens.ContentPadding),

        horizontalArrangement = Arrangement.SpaceBetween,

        verticalAlignment = Alignment.CenterVertically

    ) {

        Text(

            text = title,

            style = MaterialTheme.typography.titleMedium

        )

        Icon(

            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,

            contentDescription = null

        )

    }

}