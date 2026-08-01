package com.healthcare.patient.feature.splash.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.splash.presentation.component.AppName
import com.healthcare.patient.feature.splash.presentation.component.LoadingView
import com.healthcare.patient.feature.splash.presentation.component.Logo
import com.healthcare.patient.feature.splash.presentation.component.TagLine
import com.healthcare.patient.feature.splash.presentation.viewmodel.SplashViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToOnboarding: () -> Unit,
    onNavigateToLogin: () -> Unit,
    onNavigateToHome: () -> Unit,
    viewModel: SplashViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.isOnboardingCompleted, uiState.isLoggedIn) {

        if (uiState.isOnboardingCompleted == false) {
            onNavigateToOnboarding()
        } else if (uiState.isOnboardingCompleted == true) {
            if (uiState.isLoggedIn == true) {
                onNavigateToHome()
            } else {
                onNavigateToLogin()
            }
        }

    }

    SplashContent(modifier)

}

@Composable
private fun SplashContent(modifier: Modifier) {

    Column(
        modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center

    ) {

        Logo()

        AppName()

        TagLine()

        LoadingView()

    }

}