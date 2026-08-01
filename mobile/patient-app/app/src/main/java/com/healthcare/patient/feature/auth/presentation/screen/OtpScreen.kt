package com.healthcare.patient.feature.auth.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.auth.presentation.component.OtpHeader
import com.healthcare.patient.feature.auth.presentation.component.OtpTextField
import com.healthcare.patient.feature.auth.presentation.viewmodel.OtpViewModel
import com.healthcare.patient.ui.component.PrimaryButton
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun OtpScreen(
    onNavigateToHome: () -> Unit,
    viewModel: OtpViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            onNavigateToHome()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(AppDimens.ScreenPadding),
        verticalArrangement = Arrangement.Center
    ) {

        OtpHeader()

        Spacer(
            modifier = Modifier.height(AppDimens.Space32)
        )

        OtpTextField(
            otp = uiState.otp,
            onOtpChange = viewModel::onOtpChanged
        )

        Spacer(
            modifier = Modifier.height(AppDimens.Space24)
        )

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Verify OTP",
            onClick = viewModel::verifyOtp
        )

    }

}
