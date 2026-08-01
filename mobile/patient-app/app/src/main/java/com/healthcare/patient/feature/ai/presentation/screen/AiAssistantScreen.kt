package com.healthcare.patient.feature.ai.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.ai.presentation.component.AiHeader
import com.healthcare.patient.feature.ai.presentation.component.ChatBubble
import com.healthcare.patient.feature.ai.presentation.component.MessageInput
import com.healthcare.patient.feature.ai.presentation.component.QuickPromptSection
import com.healthcare.patient.feature.ai.presentation.viewmodel.AiViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AiAssistantScreen(

    viewModel: AiViewModel = koinViewModel()

) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()

    ) {

        AiHeader()

        QuickPromptSection(

            onPromptSelected = {

                viewModel.onMessageChanged(it)

                viewModel.sendMessage()

            }

        )

        LazyColumn(

            modifier = Modifier.weight(1f),

            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {

            items(
                uiState.chats
            ) { chat ->

                ChatBubble(

                    message = chat

                )

            }

        }

        MessageInput(

            message = uiState.message,

            onMessageChange = viewModel::onMessageChanged,

            onSend = {

                viewModel.sendMessage()

            }

        )

    }

}