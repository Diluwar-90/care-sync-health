package com.healthcare.patient.feature.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun GreetingSection(
    userName: String
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "👋 Good Morning",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(AppDimens.Space4)
        )

        Text(
            text = userName,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

    }

}