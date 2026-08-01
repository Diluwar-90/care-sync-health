package com.healthcare.patient.feature.medicalrecord.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.medicalrecord.presentation.component.MedicalRecordCard
import com.healthcare.patient.feature.medicalrecord.presentation.viewmodel.MedicalRecordViewModel
import com.healthcare.patient.ui.component.AppToolbar
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun MedicalRecordsScreen(

    onBackClick: () -> Unit,

    onNavigateToMedicalRecordDetails: () -> Unit,

    viewModel: MedicalRecordViewModel = koinViewModel()

) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()

    ) {

        AppToolbar(

            title = "Medical Records",

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
                uiState.records
            ) { record ->

                MedicalRecordCard(

                    record = record,

                    onClick = onNavigateToMedicalRecordDetails

                )

            }

        }

    }

}