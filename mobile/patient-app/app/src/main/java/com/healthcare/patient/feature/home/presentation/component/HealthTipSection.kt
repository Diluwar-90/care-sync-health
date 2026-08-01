package com.healthcare.patient.feature.home.presentation.component

import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HealthTipSection() {

    Card {

        Text(
            text = "💡 Drink enough water today.",
            style = MaterialTheme.typography.bodyLarge
        )

    }

}