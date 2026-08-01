package com.healthcare.patient.feature.medicalrecord.presentation.state


import com.healthcare.patient.feature.medicalrecord.presentation.model.MedicalRecord

data class MedicalRecordUiState(

    val records: List<MedicalRecord> = emptyList()

)