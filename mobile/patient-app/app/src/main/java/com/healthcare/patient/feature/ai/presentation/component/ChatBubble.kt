package com.healthcare.patient.feature.ai.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.healthcare.patient.feature.ai.presentation.model.ChatMessage

@Composable
fun ChatBubble(

    message: ChatMessage

) {

    Box(

        modifier = Modifier.fillMaxWidth(),

        contentAlignment =
            if (message.isUser) {
                Alignment.CenterEnd
            } else {
                Alignment.CenterStart
            }

    ) {

        Text(

            text = message.message,

            modifier = Modifier
                .wrapContentWidth()
                .background(

                    color =
                        if (message.isUser) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.surfaceVariant
                        },

                    shape = RoundedCornerShape(16.dp)

                )
                .padding(16.dp),

            color =
                if (message.isUser) {
                    MaterialTheme.colorScheme.onPrimary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }

        )

    }

}