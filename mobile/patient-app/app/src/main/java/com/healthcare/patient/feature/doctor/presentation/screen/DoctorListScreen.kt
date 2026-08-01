package com.healthcare.patient.feature.doctor.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.healthcare.patient.feature.doctor.presentation.viewmodel.DoctorViewModel
import com.healthcare.patient.feature.home.presentation.component.DoctorCard
import com.healthcare.patient.ui.component.AppToolbar
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun DoctorListScreen(

    onBackClick: () -> Unit,

    onDoctorClick: (Int) -> Unit,

    viewModel: DoctorViewModel = koinViewModel()

) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()

    ) {

        AppToolbar(

            title = "Doctors",

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
                uiState.doctors
            ) { doctor ->

                DoctorCard(

                    name = doctor.name,

                    specialization = doctor.specialization,

                    rating = doctor.rating.toString(),

                    onClick = {

                        onDoctorClick(
                            doctor.id
                        )

                    }

                )

            }

        }

    }

}