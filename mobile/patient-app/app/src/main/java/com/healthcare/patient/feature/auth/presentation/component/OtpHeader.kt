package com.healthcare.patient.feature.auth.presentation.component

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
fun OtpHeader() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "OTP Verification",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(AppDimens.Space8)
        )

        Text(
            text = "Enter the 6-digit OTP sent to your mobile number.",
            style = MaterialTheme.typography.bodyLarge
        )

    }

}