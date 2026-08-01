package com.healthcare.patient.feature.ai.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun AiHeader(

    userName: String = "Diluwar"

) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = AppDimens.Space24
            )

    ) {

        Text(

            text = "AI Health Assistant",

            style = MaterialTheme.typography.headlineSmall,

            fontWeight = FontWeight.Bold

        )

        Text(

            text = "Hello $userName 👋"

        )

        Text(

            text = "How can I help you today?"

        )

    }

}