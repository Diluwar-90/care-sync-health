package com.healthcare.patient.feature.doctor.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.doctor.presentation.viewmodel.DoctorDetailsViewModel
import com.healthcare.patient.ui.component.PrimaryButton
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.healthcare.patient.ui.component.AppToolbar

@Composable
fun DoctorDetailsScreen(

    doctorId: Int,

    onBackClick: () -> Unit,

    onBookAppointment: () -> Unit,

    viewModel: DoctorDetailsViewModel = koinViewModel()

) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(doctorId) {
        viewModel.loadDoctor(doctorId)
    }

    val doctor = uiState.doctor ?: return

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()

    ) {

        AppToolbar(

            title = "Doctor Details",

            showBackButton = true,

            onBackClick = onBackClick

        )

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(AppDimens.ScreenPadding),

            verticalArrangement = Arrangement.spacedBy(
                AppDimens.Space16
            )

        ) {

            Text(

                text = doctor.name,

                style = MaterialTheme.typography.headlineSmall

            )

            Text("Specialization : ${doctor.specialization}")

            Text("Experience : ${doctor.experience}")

            Text("Hospital : ${doctor.hospital}")

            Text("Rating : ${doctor.rating}")

            Spacer(
                modifier = Modifier.weight(1f)
            )

            PrimaryButton(

                modifier = Modifier.fillMaxWidth(),

                text = "Book Appointment",

                onClick = onBookAppointment

            )

        }

    }

}