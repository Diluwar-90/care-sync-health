package com.healthcare.patient.feature.emergency.presentation.state

import com.healthcare.patient.feature.emergency.presentation.model.EmergencyContact

data class EmergencyUiState(

    val contacts: List<EmergencyContact> = emptyList()

)