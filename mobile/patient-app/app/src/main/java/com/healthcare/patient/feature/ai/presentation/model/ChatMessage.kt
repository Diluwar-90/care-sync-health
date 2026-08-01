package com.healthcare.patient.feature.ai.presentation.model

data class ChatMessage(

    val id: Int,

    val message: String,

    val isUser: Boolean

)