package com.healthcare.patient.feature.auth.presentation.component

import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun LoginHeader() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Welcome Back",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.height(AppDimens.Space8)
        )

        Text(
            text = "Continue with your mobile number",
            style = MaterialTheme.typography.bodyLarge
        )

    }

}