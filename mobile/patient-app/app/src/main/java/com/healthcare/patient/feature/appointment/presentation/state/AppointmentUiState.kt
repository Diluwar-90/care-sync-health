package com.healthcare.patient.feature.appointment.presentation.state


import com.healthcare.patient.feature.appointment.presentation.model.Appointment
import com.healthcare.patient.feature.appointment.presentation.model.AppointmentStatus

data class AppointmentUiState(

    val selectedDate: String = "",

    val selectedTime: String = "",

    val selectedTab: AppointmentStatus = AppointmentStatus.UPCOMING,

    val appointments: List<Appointment> = emptyList()

)