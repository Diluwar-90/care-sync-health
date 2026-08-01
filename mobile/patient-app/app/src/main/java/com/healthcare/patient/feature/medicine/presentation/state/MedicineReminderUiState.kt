package com.healthcare.patient.feature.medicine.presentation.state

import com.healthcare.patient.feature.medicine.presentation.model.MedicineReminder

data class MedicineReminderUiState(

    val reminders: List<MedicineReminder> = emptyList()

)