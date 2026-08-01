package com.healthcare.patient.feature.settings.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.settings.presentation.model.SettingsItem
import com.healthcare.patient.feature.settings.presentation.state.SettingsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(

        SettingsUiState(

            settings = listOf(

                SettingsItem("Notifications"),

                SettingsItem("Dark Mode"),

                SettingsItem("Language"),

                SettingsItem("Privacy & Security"),

                SettingsItem("Terms & Conditions"),

                SettingsItem("About App"),

                SettingsItem("Rate App"),

                SettingsItem("Logout")

            )

        )

    )

    val uiState = _uiState.asStateFlow()

}