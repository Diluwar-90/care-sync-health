package com.healthcare.patient.feature.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.home.presentation.component.HealthTipSection
import com.healthcare.patient.feature.home.presentation.component.HomeTopBar
import com.healthcare.patient.feature.home.presentation.component.MedicineReminderSection
import com.healthcare.patient.feature.home.presentation.component.QuickActionSection
import com.healthcare.patient.feature.home.presentation.component.RecentMedicalRecordSection
import com.healthcare.patient.feature.home.presentation.component.SearchSection
import com.healthcare.patient.feature.home.presentation.component.TopDoctorSection
import com.healthcare.patient.feature.home.presentation.component.UpcomingAppointmentSection
import com.healthcare.patient.feature.home.presentation.model.QuickAction
import com.healthcare.patient.feature.home.presentation.viewmodel.HomeViewModel
import com.healthcare.patient.ui.dimens.AppDimens
import com.healthcare.patient.ui.icons.AppIcons
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(

    contentPadding: PaddingValues,

    onNavigateToDoctorList: () -> Unit,

    onNavigateToMyAppointments: () -> Unit,

    onNavigateToMedicalRecords: () -> Unit,

    onNavigateToAiAssistant: () -> Unit,

    onNavigateToNotification: () -> Unit,

    onNavigateToProfile: () -> Unit,

    viewModel: HomeViewModel = koinViewModel()

) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LazyColumn(

        modifier = Modifier.fillMaxSize(),

        contentPadding = PaddingValues(

            top = contentPadding.calculateTopPadding() + AppDimens.ScreenPadding,

            bottom = contentPadding.calculateBottomPadding() + AppDimens.ScreenPadding,

            start = AppDimens.ScreenPadding,

            end = AppDimens.ScreenPadding

        ),

        verticalArrangement = Arrangement.spacedBy(
            AppDimens.Space24
        )

    ) {

        item {

            HomeTopBar(

                userName = uiState.userName,

                onNotificationClick = onNavigateToNotification,

                onProfileClick = onNavigateToProfile

            )

        }

        item {

            SearchSection(

                searchText = uiState.searchText,

                onSearchChange = viewModel::onSearchChanged

            )

        }

        item {

            QuickActionSection(

                actions = listOf(

                    QuickAction(

                        title = "Book",

                        icon = Icons.Default.CalendarMonth

                    ),

                    QuickAction(

                        title = "Doctors",

                        icon = AppIcons.Person

                    ),

                    QuickAction(

                        title = "Records",

                        icon = Icons.Default.Description

                    ),

                    QuickAction(

                        title = "AI Assistant",

                        icon = Icons.Default.SmartToy

                    )

                ),

                onClick = { action ->

                    when (action.title) {

                        "Book" -> {

                            onNavigateToMyAppointments()

                        }

                        "Doctors" -> {

                            onNavigateToDoctorList()

                        }

                        "Records" -> {

                            onNavigateToMedicalRecords()

                        }

                        "AI Assistant" -> {

                            onNavigateToAiAssistant()

                        }

                    }

                }

            )

        }

        item {

            UpcomingAppointmentSection()

        }

        item {

            MedicineReminderSection()

        }

        item {

            RecentMedicalRecordSection()

        }

        item {

            HealthTipSection()

        }

        item {

            TopDoctorSection()

        }

    }

}