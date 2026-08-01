package com.healthcare.patient.navigation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.healthcare.patient.feature.ai.presentation.screen.AiAssistantScreen
import com.healthcare.patient.feature.appointment.presentation.screen.MyAppointmentsScreen
import com.healthcare.patient.feature.home.presentation.screen.HomeScreen
import com.healthcare.patient.feature.profile.presentation.screen.ProfileScreen

@Composable
fun MainScreen(
    rootNavController: NavHostController,

    onLogout: () -> Unit

) {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = {

            BottomBar(
                navController = navController
            )

        }

    ) { paddingValues ->

        NavHost(

            navController = navController,

            startDestination = BottomDestination.Home.route,

        ) {

            /*
             * Home
             */
            composable(
                BottomDestination.Home.route
            ) {

                HomeScreen(
                    contentPadding = paddingValues,

                    onNavigateToDoctorList = {

                        rootNavController.navigate(
                            Destination.DoctorList.route
                        )

                    },

                    onNavigateToMyAppointments = {

                        navController.navigate(BottomDestination.Appointment.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    },

                    onNavigateToMedicalRecords = {

                        rootNavController.navigate(
                            Destination.MedicalRecords.route
                        )

                    },

                    onNavigateToAiAssistant = {

                        navController.navigate(BottomDestination.Ai.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    },

                    onNavigateToNotification = {

                        rootNavController.navigate(
                            Destination.Notification.route
                        )

                    },

                    onNavigateToProfile = {

                        navController.navigate(BottomDestination.Profile.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    },

                )

            }

            /*
             * Appointments
             */
            composable(
                BottomDestination.Appointment.route
            ) {

                MyAppointmentsScreen(

                    onNavigateToAppointmentDetails = {

                        rootNavController.navigate(
                            Destination.AppointmentDetails.route
                        )

                    }

                )

            }

            /*
             * AI
             */
            composable(
                BottomDestination.Ai.route
            ) {

                AiAssistantScreen()

            }

            /*
             * Profile
             */
            composable(
                BottomDestination.Profile.route
            ) {

                ProfileScreen(

                    onBackClick = {},

                    onNavigateToPersonalInformation = {

                        rootNavController.navigate(
                            Destination.PersonalInformation.route
                        )

                    },

                    onNavigateToFamily = {

                        rootNavController.navigate(
                            Destination.Family.route
                        )

                    },

                    onNavigateToEmergencyContacts = {

                        rootNavController.navigate(
                            Destination.EmergencyContacts.route
                        )

                    },

                    onNavigateToMedicalRecords = {

                        rootNavController.navigate(
                            Destination.MedicalRecords.route
                        )

                    },

                    onNavigateToMedicineReminder = {

                        rootNavController.navigate(
                            Destination.MedicineReminder.route
                        )

                    },

                    onNavigateToSettings = {

                        rootNavController.navigate(
                            Destination.Settings.route
                        )

                    },
                    onNavigateToNotification = {
                        rootNavController.navigate(
                            Destination.Notification.route
                        )
                    },


                )

            }

        }

    }

}