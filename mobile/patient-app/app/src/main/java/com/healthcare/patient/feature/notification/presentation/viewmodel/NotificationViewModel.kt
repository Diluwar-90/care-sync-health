package com.healthcare.patient.feature.notification.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.notification.presentation.model.NotificationItem
import com.healthcare.patient.feature.notification.presentation.state.NotificationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotificationViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(

        NotificationUiState(

            notifications = listOf(

                NotificationItem(
                    id = 1,
                    title = "Appointment Confirmed",
                    description = "Your appointment with Dr. Ahmed Khan is confirmed.",
                    time = "10 min ago",
                    isRead = false
                ),

                NotificationItem(
                    id = 2,
                    title = "Medicine Reminder",
                    description = "Time to take your morning medicine.",
                    time = "1 hour ago",
                    isRead = true
                ),

                NotificationItem(
                    id = 3,
                    title = "Lab Report Ready",
                    description = "Your blood test report is available.",
                    time = "Yesterday",
                    isRead = true
                )

            )

        )

    )

    val uiState = _uiState.asStateFlow()

}