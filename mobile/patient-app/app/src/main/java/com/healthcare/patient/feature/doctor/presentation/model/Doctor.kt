package com.healthcare.patient.feature.doctor.presentation.model

data class Doctor(

    val id: Int,

    val name: String,

    val specialization: String,

    val experience: String,

    val rating: Double,

    val hospital: String
)