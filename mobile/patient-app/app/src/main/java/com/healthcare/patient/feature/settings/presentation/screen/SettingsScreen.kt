package com.healthcare.patient.feature.settings.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.profile.presentation.component.ProfileMenuItem
import com.healthcare.patient.feature.settings.presentation.viewmodel.SettingsViewModel
import com.healthcare.patient.ui.component.AppToolbar
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsScreen(

    onBackClick: () -> Unit,

    onNotificationsClick: () -> Unit,

    onPrivacyClick: () -> Unit,

    onAboutClick: () -> Unit,

    onTermsClick: () -> Unit,

    onLogoutClick: () -> Unit,

    viewModel: SettingsViewModel = koinViewModel()

) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()

    ) {

        AppToolbar(

            title = "Settings",

            showBackButton = true,

            onBackClick = onBackClick

        )

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(AppDimens.ScreenPadding),

            verticalArrangement = Arrangement.spacedBy(
                AppDimens.Space12
            )

        ) {

            items(
                uiState.settings
            ) { item ->

                ProfileMenuItem(

                    title = item.title,

                    onClick = {

                        when (item.title) {

                            "Notifications" -> {
                                onNotificationsClick()
                            }

                            "Privacy & Security" -> {
                                onPrivacyClick()
                            }

                            "Terms & Conditions" -> {
                                onTermsClick()
                            }

                            "About App" -> {
                                onAboutClick()
                            }

                            "Logout" -> {
                                onLogoutClick()
                            }

                        }

                    }

                )

            }

        }

    }

}