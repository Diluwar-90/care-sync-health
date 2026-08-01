package com.healthcare.patient.feature.medicalrecord.presentation.model

data class MedicalRecord(

    val id: Int,

    val title: String,

    val category: String,

    val hospital: String,

    val date: String

)