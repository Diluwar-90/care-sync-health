package com.healthcare.patient.feature.ai.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.healthcare.patient.ui.component.PrimaryButton

@Composable
fun QuickPromptSection(

    onPromptSelected: (String) -> Unit

) {

    Column(

        modifier = Modifier.fillMaxWidth(),

        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {

        PrimaryButton(

            text = "🤒 Check Symptoms",

            onClick = {

                onPromptSelected(
                    "I have fever and cough."
                )

            }

        )

        PrimaryButton(

            text = "💊 Medicine Information",

            onClick = {

                onPromptSelected(
                    "Explain this medicine."
                )

            }

        )

        PrimaryButton(

            text = "📄 Explain Medical Report",

            onClick = {

                onPromptSelected(
                    "Explain my medical report."
                )

            }

        )

        PrimaryButton(

            text = "❤️ Health Tips",

            onClick = {

                onPromptSelected(
                    "Give me health tips."
                )

            }

        )

    }

}