package com.healthcare.patient.feature.family.presentation.state

import com.healthcare.patient.feature.family.presentation.model.FamilyMember

data class FamilyUiState(

    val members: List<FamilyMember> = emptyList()

)