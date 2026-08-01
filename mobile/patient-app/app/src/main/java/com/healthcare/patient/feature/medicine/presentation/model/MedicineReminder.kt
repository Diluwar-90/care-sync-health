package com.healthcare.patient.feature.medicine.presentation.model

data class MedicineReminder(

    val id: Int,

    val medicineName: String,

    val dosage: String,

    val time: String,

    val frequency: String,

    val isCompleted: Boolean

)