package com.healthcare.patient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.healthcare.patient.feature.ai.presentation.screen.AiAssistantScreen
import com.healthcare.patient.feature.appointment.presentation.screen.AppointmentDetailsScreen
import com.healthcare.patient.feature.appointment.presentation.screen.BookingScreen
import com.healthcare.patient.feature.appointment.presentation.screen.BookingSuccessScreen
import com.healthcare.patient.feature.appointment.presentation.screen.MyAppointmentsScreen
import com.healthcare.patient.feature.auth.presentation.screen.LoginScreen
import com.healthcare.patient.feature.auth.presentation.screen.OtpScreen
import com.healthcare.patient.feature.doctor.presentation.screen.DoctorDetailsScreen
import com.healthcare.patient.feature.doctor.presentation.screen.DoctorListScreen
import com.healthcare.patient.feature.emergency.presentation.screen.EmergencyContactsScreen
import com.healthcare.patient.feature.family.presentation.screen.FamilyScreen
import com.healthcare.patient.feature.home.presentation.screen.HomeScreen
import com.healthcare.patient.feature.medicalrecord.presentation.screen.MedicalRecordDetailsScreen
import com.healthcare.patient.feature.medicalrecord.presentation.screen.MedicalRecordsScreen
import com.healthcare.patient.feature.medicine.presentation.screen.MedicineReminderScreen
import com.healthcare.patient.feature.notification.presentation.screen.NotificationScreen
import com.healthcare.patient.feature.onboarding.presentation.screen.OnboardingScreen
import com.healthcare.patient.feature.profile.presentation.screen.EditProfileScreen
import com.healthcare.patient.feature.profile.presentation.screen.PersonalInformationScreen
import com.healthcare.patient.feature.profile.presentation.screen.ProfileScreen
import com.healthcare.patient.feature.settings.presentation.screen.SettingsScreen
import com.healthcare.patient.feature.splash.presentation.screen.SplashScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.Splash.route
    ) {

        composable(Destination.Splash.route) {

            SplashScreen(

                onNavigateToOnboarding = {

                    navController.navigate(Destination.Onboarding.route) {

                        popUpTo(Destination.Splash.route) {
                            inclusive = true
                        }

                    }

                },

                onNavigateToLogin = {

                    navController.navigate(Destination.Login.route) {

                        popUpTo(Destination.Splash.route) {
                            inclusive = true
                        }

                    }

                },

                onNavigateToHome = {

                    navController.navigate(Destination.Main.route) {

                        popUpTo(Destination.Splash.route) {
                            inclusive = true
                        }

                    }

                }

            )

        }
        composable(Destination.Onboarding.route) {

            OnboardingScreen(

                onNavigateToLogin = {

                    navController.navigate(Destination.Login.route) {

                        popUpTo(Destination.Onboarding.route) {
                            inclusive = true
                        }

                    }

                }

            )
        }

        composable(Destination.Login.route) {

            LoginScreen(

                onNavigateToOtp = {

                    navController.navigate(Destination.Otp.route)

                }

            )

        }

        composable(Destination.Otp.route) {

            OtpScreen(

                onNavigateToHome = {

                    navController.navigate(Destination.Main.route) {

                        popUpTo(Destination.Login.route) {
                            inclusive = true
                        }

                    }

                }

            )

        }

        composable(Destination.Main.route) {
            MainScreen(
                rootNavController = navController,
                onLogout = {
                    navController.navigate(Destination.Login.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(Destination.DoctorList.route) {

            DoctorListScreen(

                onBackClick = {

                    navController.popBackStack()

                },

                onDoctorClick = { doctorId ->

                    navController.navigate(
                        Destination.DoctorDetails.createRoute(doctorId)
                    )

                }

            )

        }

        composable(
            route = Destination.DoctorDetails.route
        ) { backStackEntry ->

            val doctorId = backStackEntry.arguments
                ?.getString("doctorId")
                ?.toIntOrNull() ?: 0

            DoctorDetailsScreen(

                doctorId = doctorId,

                onBackClick = {

                    navController.popBackStack()

                },

                onBookAppointment = {

                    navController.navigate(
                        Destination.Booking.route
                    )

                }

            )

        }

        composable(Destination.Booking.route) {

            BookingScreen(

                onBookingSuccess = {

                    navController.navigate(
                        Destination.BookingSuccess.route
                    )

                }

            )

        }

        composable(Destination.BookingSuccess.route) {

            BookingSuccessScreen(

                onGoHome = {

                    navController.navigate(Destination.Main.route) {

                        popUpTo(Destination.Main.route) {
                            inclusive = false
                        }

                        launchSingleTop = true

                    }

                }

            )

        }

        composable(Destination.MyAppointments.route) {

            MyAppointmentsScreen(
                onNavigateToAppointmentDetails = {

                    navController.navigate(
                        Destination.AppointmentDetails.route
                    )

                }
            )

        }

        composable(
            Destination.MedicalRecords.route
        ) {

            MedicalRecordsScreen(

                onBackClick = {

                    navController.popBackStack()

                },

                onNavigateToMedicalRecordDetails = {

                    navController.navigate(
                        Destination.MedicalRecordDetails.route
                    )

                }

            )

        }

        composable(
            Destination.MedicalRecordDetails.route
        ) {

            MedicalRecordDetailsScreen(

                onBackClick = {

                    navController.popBackStack()

                },

                onDownloadClick = {

                    // Future Backend

                }

            )

        }

        composable(
            Destination.AiAssistant.route
        ) {

            AiAssistantScreen()

        }

        composable(
            Destination.Notification.route
        ) {

            NotificationScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )

        }

        composable(
            Destination.Profile.route
        ) {

            ProfileScreen(

                onBackClick = {

                    navController.popBackStack()

                },

                onNavigateToSettings = {

                    navController.navigate(
                        Destination.Settings.route
                    )

                },
                onNavigateToFamily = {
                    navController.navigate(
                        Destination.Family.route
                    )

                },
                onNavigateToEmergencyContacts = {
                    navController.navigate(
                        Destination.EmergencyContacts.route
                    )
                },
                onNavigateToMedicineReminder = {
                    navController.navigate(
                        Destination.MedicineReminder.route
                    )
                },
                onNavigateToMedicalRecords = {
                    navController.navigate(
                        Destination.MedicalRecords.route
                    )
                },
                onNavigateToPersonalInformation = {
                    navController.navigate(
                        Destination.PersonalInformation.route
                    )
                },
                onNavigateToNotification = {
                    navController.navigate(
                        Destination.Notification.route
                    )
                }

            )

        }

        composable(
            Destination.Settings.route
        ) {

            SettingsScreen(

                onBackClick = {

                    navController.popBackStack()

                },

                onNotificationsClick = {

                    navController.navigate(
                        Destination.Notification.route
                    )

                },

                onPrivacyClick = {

                    // Next Phase

                },

                onAboutClick = {

                    // Next Phase

                },

                onTermsClick = {

                    // Next Phase

                },

                onLogoutClick = {

                    navController.navigate(
                        Destination.Login.route
                    ) {

                        popUpTo(0)

                    }

                }

            )

        }

        composable(
            Destination.Family.route
        ) {

            FamilyScreen(

                onBackClick = {

                    navController.popBackStack()

                }

            )

        }

        composable(
            Destination.EmergencyContacts.route
        ) {

            EmergencyContactsScreen(

                onBackClick = {

                    navController.popBackStack()

                }

            )

        }

        composable(
            Destination.MedicineReminder.route
        ) {

            MedicineReminderScreen(

                onBackClick = {

                    navController.popBackStack()

                }

            )

        }

        composable(
            Destination.PersonalInformation.route
        ) {

            PersonalInformationScreen(

                onBackClick = {

                    navController.popBackStack()

                },
                onEditProfileClick = {

                    navController.navigate(
                        Destination.EditProfile.route
                    )

                }

            )

        }

        composable(
            Destination.EditProfile.route
        ) {

            EditProfileScreen(

                onBackClick = {

                    navController.popBackStack()

                },

                onSaveClick = {

                    navController.popBackStack()

                }

            )

        }

        composable(
            Destination.AppointmentDetails.route
        ) {

            AppointmentDetailsScreen(

                onBackClick = {

                    navController.popBackStack()

                },

                onCancelAppointment = {

                    // Future Backend

                }

            )

        }



    }
}