package com.healthcare.patient.feature.emergency.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.emergency.presentation.model.EmergencyContact
import com.healthcare.patient.feature.emergency.presentation.state.EmergencyUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EmergencyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(

        EmergencyUiState(

            contacts = listOf(

                EmergencyContact(
                    id = 1,
                    name = "John Doe",
                    relation = "Father",
                    phoneNumber = "+91 9876543210"
                ),

                EmergencyContact(
                    id = 2,
                    name = "Jane Doe",
                    relation = "Spouse",
                    phoneNumber = "+91 9876501234"
                )

            )

        )

    )

    val uiState = _uiState.asStateFlow()

}