package com.healthcare.patient.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthcare.patient.ui.theme.PatientappTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(16.dp),
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (onClick != null && enabled) {
                    Modifier.clickable { onClick() }
                } else {
                    Modifier
                }
            ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            content = {

                androidx.compose.foundation.layout.Box(
                    modifier = Modifier.padding(contentPadding)
                ) {
                    content()
                }

            }
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun AppCardPreview() {

    PatientappTheme() {

        AppCard {

            Text(
                text = "Doctor Card"
            )

        }

    }

}