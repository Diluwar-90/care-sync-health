package com.healthcare.patient.feature.doctor.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.doctor.presentation.model.Doctor
import com.healthcare.patient.feature.doctor.presentation.state.DoctorUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DoctorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        DoctorUiState(
            doctors = listOf(
                Doctor(
                    1,
                    "Dr. Ahmed Khan",
                    "Cardiologist",
                    "10 Years",
                    4.9,
                    "Apollo Hospital"
                ),
                Doctor(
                    2,
                    "Dr. Priya Sharma",
                    "Dentist",
                    "8 Years",
                    4.8,
                    "Care Hospital"
                ),
                Doctor(
                    3,
                    "Dr. David Wilson",
                    "Neurologist",
                    "12 Years",
                    4.7,
                    "Yashoda Hospital"
                )
            )
        )
    )

    val uiState = _uiState.asStateFlow()

}