package com.healthcare.patient.feature.medicalrecord.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.healthcare.patient.feature.medicalrecord.presentation.component.MedicalRecordInfoItem
import com.healthcare.patient.ui.component.AppToolbar
import com.healthcare.patient.ui.component.PrimaryButton
import com.healthcare.patient.ui.dimens.AppDimens

@Composable
fun MedicalRecordDetailsScreen(

    onBackClick: () -> Unit,

    onDownloadClick: () -> Unit

) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()

    ) {

        AppToolbar(

            title = "Medical Record Details",

            showBackButton = true,

            onBackClick = onBackClick

        )

        Column(

            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(
                    AppDimens.ScreenPadding
                ),

            verticalArrangement = Arrangement.spacedBy(
                AppDimens.Space16
            )

        ) {

            MedicalRecordInfoItem(

                title = "Title",

                value = "Blood Test Report"

            )

            MedicalRecordInfoItem(

                title = "Category",

                value = "Lab Report"

            )

            MedicalRecordInfoItem(

                title = "Hospital",

                value = "Apollo Hospital"

            )

            MedicalRecordInfoItem(

                title = "Date",

                value = "20 Jul 2026"

            )

            MedicalRecordInfoItem(

                title = "Doctor",

                value = "Dr. Ahmed Khan"

            )

            MedicalRecordInfoItem(

                title = "Description",

                value = "Complete Blood Count (CBC)"

            )

            MedicalRecordInfoItem(

                title = "Attachment",

                value = "blood_report.pdf"

            )

            PrimaryButton(

                text = "Download",

                onClick = onDownloadClick

            )

        }

    }

}