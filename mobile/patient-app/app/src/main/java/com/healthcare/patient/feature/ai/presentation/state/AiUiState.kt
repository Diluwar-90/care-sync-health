package com.healthcare.patient.feature.ai.presentation.state

import com.healthcare.patient.feature.ai.presentation.model.ChatMessage

data class AiUiState(

    val message: String = "",

    val chats: List<ChatMessage> = emptyList()

)