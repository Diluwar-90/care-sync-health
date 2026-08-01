package com.healthcare.patient.feature.notification.presentation.state

import com.healthcare.patient.feature.notification.presentation.model.NotificationItem

data class NotificationUiState(

    val notifications: List<NotificationItem> = emptyList()

)