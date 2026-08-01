package com.healthcare.patient.feature.settings.presentation.state

import com.healthcare.patient.feature.settings.presentation.model.SettingsItem

data class SettingsUiState(

    val settings: List<SettingsItem> = emptyList()

)