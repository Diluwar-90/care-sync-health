package com.healthcare.patient.feature.medicine.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.medicine.presentation.model.MedicineReminder
import com.healthcare.patient.feature.medicine.presentation.state.MedicineReminderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MedicineReminderViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(

        MedicineReminderUiState(

            reminders = listOf(

                MedicineReminder(

                    id = 1,

                    medicineName = "Paracetamol",

                    dosage = "500 mg",

                    time = "08:00 AM",

                    frequency = "Daily",

                    isCompleted = false

                ),

                MedicineReminder(

                    id = 2,

                    medicineName = "Vitamin D",

                    dosage = "1 Tablet",

                    time = "09:00 PM",

                    frequency = "Daily",

                    isCompleted = true

                )

            )

        )

    )

    val uiState = _uiState.asStateFlow()

}