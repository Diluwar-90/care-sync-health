package com.healthcare.patient.feature.medicalrecord.presentation.viewmodel


import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.medicalrecord.presentation.model.MedicalRecord
import com.healthcare.patient.feature.medicalrecord.presentation.state.MedicalRecordUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MedicalRecordViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(

        MedicalRecordUiState(

            records = listOf(

                MedicalRecord(
                    id = 1,
                    title = "Blood Test Report",
                    category = "Lab Report",
                    hospital = "Apollo Hospital",
                    date = "20 Jul 2026"
                ),

                MedicalRecord(
                    id = 2,
                    title = "Heart Prescription",
                    category = "Prescription",
                    hospital = "Care Hospital",
                    date = "15 Jul 2026"
                )

            )

        )

    )

    val uiState = _uiState.asStateFlow()

}