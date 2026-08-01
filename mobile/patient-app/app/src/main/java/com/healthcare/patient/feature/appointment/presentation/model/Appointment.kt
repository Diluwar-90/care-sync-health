package com.healthcare.patient.feature.appointment.presentation.model

data class Appointment(

    val id: Int,

    val doctorName: String,

    val specialization: String,

    val hospital: String,

    val date: String,

    val time: String,

    val status: AppointmentStatus

)