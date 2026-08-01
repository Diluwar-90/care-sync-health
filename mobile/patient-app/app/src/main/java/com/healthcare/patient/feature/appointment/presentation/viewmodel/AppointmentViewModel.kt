package com.healthcare.patient.feature.appointment.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.appointment.presentation.model.Appointment
import com.healthcare.patient.feature.appointment.presentation.model.AppointmentStatus
import com.healthcare.patient.feature.appointment.presentation.state.AppointmentUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppointmentViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AppointmentUiState())
    val uiState = _uiState.asStateFlow()
    init {

        _uiState.value = _uiState.value.copy(

            appointments = listOf(

                Appointment(
                    id = 1,
                    doctorName = "Dr. Ahmed Khan",
                    specialization = "Cardiologist",
                    hospital = "Apollo Hospital",
                    date = "25 Jul 2026",
                    time = "10:30 AM",
                    status = AppointmentStatus.UPCOMING
                ),

                Appointment(
                    id = 2,
                    doctorName = "Dr. Priya Sharma",
                    specialization = "Dentist",
                    hospital = "Care Hospital",
                    date = "15 Jul 2026",
                    time = "09:00 AM",
                    status = AppointmentStatus.COMPLETED
                )

            )

        )

    }

    fun onDateSelected(date: String) {

        _uiState.value = _uiState.value.copy(
            selectedDate = date
        )

    }

    fun onTimeSelected(time: String) {

        _uiState.value = _uiState.value.copy(
            selectedTime = time
        )

    }

    fun onTabChanged(
        status: AppointmentStatus
    ) {

        _uiState.value = _uiState.value.copy(

            selectedTab = status

        )

    }

}