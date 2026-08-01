package com.healthcare.patient.navigation

sealed class Destination(val route: String) {

    data object Splash : Destination("splash")

    data object Login : Destination("login")

    data object Home : Destination("dashboard")

    data object Otp : Destination("otp")

    data object Onboarding : Destination("onboarding")

    data object DoctorList : Destination("doctor_list")

    data object DoctorDetails : Destination("doctor_details/{doctorId}") {

        fun createRoute(
            doctorId: Int
        ) = "doctor_details/$doctorId"

    }

    data object Booking : Destination("booking")

    data object BookingSuccess : Destination("booking_success")

    data object MyAppointments : Destination("my_appointments")

    data object MedicalRecords : Destination(
        "medical_records"
    )

    data object AiAssistant : Destination(
        "ai_assistant"
    )

    data object Notification : Destination(
        "notification"
    )

    data object Profile : Destination(
        "profile"
    )

    data object Settings : Destination(
        "settings"
    )

    data object Family : Destination(
        "family"
    )

    data object EmergencyContacts : Destination(
        "emergency_contacts"
    )

    data object MedicineReminder : Destination(
        "medicine_reminder"
    )

    data object PersonalInformation : Destination(
        "personal_information"
    )

    data object EditProfile : Destination(
        "edit_profile"
    )

    data object AppointmentDetails : Destination(
        "appointment_details"
    )

    data object MedicalRecordDetails : Destination(
        "medical_record_details"
    )

    data object Main : Destination(
        "main"
    )

}