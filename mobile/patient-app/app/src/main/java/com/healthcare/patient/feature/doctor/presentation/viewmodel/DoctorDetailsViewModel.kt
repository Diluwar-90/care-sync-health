package com.healthcare.patient.feature.doctor.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.doctor.presentation.model.Doctor
import com.healthcare.patient.feature.doctor.presentation.state.DoctorDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DoctorDetailsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DoctorDetailsUiState())
    val uiState = _uiState.asStateFlow()

    fun loadDoctor(id: Int) {

        _uiState.value = DoctorDetailsUiState(

            doctor = Doctor(

                id = id,

                name = "Dr. Ahmed Khan",

                specialization = "Cardiologist",

                experience = "10 Years",

                rating = 4.9,

                hospital = "Apollo Hospital"

            )

        )

    }

}