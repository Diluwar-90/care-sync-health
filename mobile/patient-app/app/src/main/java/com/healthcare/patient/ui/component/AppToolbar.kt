package com.healthcare.patient.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.healthcare.patient.ui.theme.PatientappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    title: String,
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {

    CenterAlignedTopAppBar(

        title = {

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )

        },

        navigationIcon = {

            if (showBackButton) {

                IconButton(
                    onClick = onBackClick
                ) {

                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Back"
                    )

                }

            }

        },

        actions = actions,

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        )

    )

}

@Preview(showBackground = true)
@Composable
private fun ToolbarPreview() {

    PatientappTheme(){

        AppToolbar(
            title = "Appointments"
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun ToolbarBackPreview() {

    PatientappTheme() {

        AppToolbar(
            title = "Doctor Details",
            showBackButton = true
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun ToolbarActionPreview() {

    PatientappTheme() {

        AppToolbar(
            title = "Home",
            actions = {

                IconButton(
                    onClick = {}
                ) {

                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = ""
                    )

                }

            }
        )

    }

}