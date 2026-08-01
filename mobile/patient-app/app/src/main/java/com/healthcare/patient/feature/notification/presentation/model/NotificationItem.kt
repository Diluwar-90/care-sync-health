package com.healthcare.patient.feature.notification.presentation.model

data class NotificationItem(

    val id: Int,

    val title: String,

    val description: String,

    val time: String,

    val isRead: Boolean

)