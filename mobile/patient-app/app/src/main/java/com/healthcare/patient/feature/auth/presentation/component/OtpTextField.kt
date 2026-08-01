package com.healthcare.patient.feature.auth.presentation.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OtpTextField(
    otp: String,
    onOtpChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        modifier = modifier,
        value = otp,
        onValueChange = {

            if (it.length <= 6) {
                onOtpChange(it)
            }

        },
        label = {
            Text("OTP")
        },
        singleLine = true
    )

}