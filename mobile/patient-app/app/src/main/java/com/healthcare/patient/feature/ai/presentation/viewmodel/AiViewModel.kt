package com.healthcare.patient.feature.ai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.ai.presentation.model.ChatMessage
import com.healthcare.patient.feature.ai.presentation.state.AiUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AiViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AiUiState())

    val uiState = _uiState.asStateFlow()

    fun onMessageChanged(message: String) {

        _uiState.value = _uiState.value.copy(
            message = message
        )

    }

    fun sendMessage() {

        if (_uiState.value.message.isBlank()) {
            return
        }

        val userMessage = ChatMessage(

            id = _uiState.value.chats.size + 1,

            message = _uiState.value.message,

            isUser = true

        )

        val aiMessage = ChatMessage(

            id = _uiState.value.chats.size + 2,

            message = "This is a demo AI response.",

            isUser = false

        )

        _uiState.value = _uiState.value.copy(

            message = "",

            chats = _uiState.value.chats + userMessage + aiMessage

        )

    }

}