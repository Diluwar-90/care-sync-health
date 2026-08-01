package com.healthcare.patient.feature.auth.presentation.screen

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.auth.presentation.component.LoginHeader
import com.healthcare.patient.feature.auth.presentation.viewmodel.LoginViewModel
import com.healthcare.patient.ui.component.PhoneTextField
import com.healthcare.patient.ui.component.PrimaryButton
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    onNavigateToOtp: () -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(AppDimens.ScreenPadding),
        verticalArrangement = Arrangement.Center
    ) {

        LoginHeader()

        Spacer(
            modifier = Modifier.height(AppDimens.Space32)
        )

        PhoneTextField(
            phone = uiState.mobileNumber,
            onPhoneChange = viewModel::onMobileNumberChanged
        )

        Spacer(
            modifier = Modifier.height(AppDimens.Space24)
        )

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Continue",
            onClick = onNavigateToOtp
        )

    }

}