package com.healthcare.patient.feature.profile.presentation.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.profile.presentation.component.ProfileMenuItem
import com.healthcare.patient.feature.profile.presentation.model.ProfileMenu
import com.healthcare.patient.feature.profile.presentation.viewmodel.ProfileViewModel
import com.healthcare.patient.ui.component.AppToolbar
import com.healthcare.patient.ui.component.Avatar
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(

    onBackClick: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToFamily: () -> Unit,
    onNavigateToEmergencyContacts: () -> Unit,
    onNavigateToMedicineReminder: () -> Unit,
    onNavigateToMedicalRecords: () -> Unit,
    onNavigateToPersonalInformation: () -> Unit,
    onNavigateToNotification: () -> Unit,
    viewModel: ProfileViewModel = koinViewModel()

) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val profile = uiState.profile ?: return

    val menus = listOf(

        ProfileMenu("Personal Information"),

        ProfileMenu("Family Members"),

        ProfileMenu("Emergency Contacts"),

        ProfileMenu("Medical Records"),

        ProfileMenu("Medicine Reminder"),

        ProfileMenu("Notifications"),

        ProfileMenu("Settings"),

        ProfileMenu("Logout")

    )

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()

    ) {

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(AppDimens.ScreenPadding),

            verticalArrangement = Arrangement.spacedBy(
                AppDimens.Space16
            ),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            item {

                Avatar()

            }

            item {

                androidx.compose.material3.Text(
                    text = profile.fullName
                )

            }

            item {

                androidx.compose.material3.Text(
                    text = profile.email
                )

            }

            item {

                androidx.compose.material3.Text(
                    text = profile.phone
                )

            }

            items(menus) { menu ->

                ProfileMenuItem(

                    title = menu.title,

                    onClick = {

                        when (menu.title) {

                            "Settings" -> {

                                onNavigateToSettings()

                            }

                            "Family Members" -> {

                                onNavigateToFamily()

                            }

                            "Emergency Contacts" -> {

                                onNavigateToEmergencyContacts()

                            }

                            "Medicine Reminder" -> {

                                onNavigateToMedicineReminder()

                            }

                            "Medical Records" -> {

                                onNavigateToMedicalRecords()

                            }

                            "Personal Information" -> {

                                onNavigateToPersonalInformation()

                            }

                            "Notifications" -> {

                                onNavigateToNotification()

                            }

                        }

                    }

                )

            }

        }

    }

}