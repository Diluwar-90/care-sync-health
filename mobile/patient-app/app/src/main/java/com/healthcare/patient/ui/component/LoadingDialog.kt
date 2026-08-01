package com.healthcare.patient.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthcare.patient.ui.theme.PatientappTheme


@Composable
fun LoadingDialog(
    show: Boolean,
    message: String = "Please wait..."
) {

    if (!show) return

    AlertDialog(
        onDismissRequest = { },

        confirmButton = { },

        title = {

            Text(
                text = "Loading",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

        },

        text = {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp)
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium
                )

            }

        }

    )

}

@Preview(showBackground = true)
@Composable
private fun LoadingDialogPreview() {

    PatientappTheme() {

        LoadingDialog(
            show = true
        )

    }

}