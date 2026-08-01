package com.healthcare.patient.feature.emergency.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.emergency.presentation.component.EmergencyContactCard
import com.healthcare.patient.feature.emergency.presentation.viewmodel.EmergencyViewModel
import com.healthcare.patient.ui.component.AppToolbar
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun EmergencyContactsScreen(

    onBackClick: () -> Unit,

    viewModel: EmergencyViewModel = koinViewModel()

) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()

    ) {

        AppToolbar(

            title = "Emergency Contacts",

            showBackButton = true,

            onBackClick = onBackClick

        )

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(AppDimens.ScreenPadding),

            verticalArrangement = Arrangement.spacedBy(
                AppDimens.Space16
            )

        ) {

            items(
                uiState.contacts
            ) { contact ->

                EmergencyContactCard(

                    contact = contact,

                    onClick = {

                        // Future:
                        // View Details
                        // Edit Contact
                        // Call Contact

                    }

                )

            }

        }

    }

}