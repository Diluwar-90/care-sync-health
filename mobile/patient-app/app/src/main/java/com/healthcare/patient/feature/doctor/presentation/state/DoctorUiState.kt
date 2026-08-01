package com.healthcare.patient.feature.doctor.presentation.state

import com.healthcare.patient.feature.doctor.presentation.model.Doctor

data class DoctorUiState(

    val doctors: List<Doctor> = emptyList()

)