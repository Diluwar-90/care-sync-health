package com.healthcare.patient.feature.profile.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.profile.presentation.viewmodel.ProfileViewModel
import com.healthcare.patient.ui.component.AppToolbar
import com.healthcare.patient.ui.component.PrimaryButton
import com.healthcare.patient.ui.component.AppTextField
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun EditProfileScreen(

    onBackClick: () -> Unit,

    onSaveClick: () -> Unit,

    viewModel: ProfileViewModel = koinViewModel()

) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val profile = uiState.profile ?: return

    Column(

        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()

    ) {

        AppToolbar(

            title = "Edit Profile",

            showBackButton = true,

            onBackClick = onBackClick

        )

        Column(

            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(AppDimens.ScreenPadding),

            verticalArrangement = Arrangement.spacedBy(
                AppDimens.Space16
            )

        ) {

            AppTextField(

                value = profile.fullName,

                label = "Full Name",

                onValueChange = {}

            )

            AppTextField(

                value = profile.phone,

                label = "Phone Number",

                onValueChange = {}

            )

            AppTextField(

                value = profile.email,

                label = "Email",

                onValueChange = {}

            )

            AppTextField(

                value = profile.gender,

                label = "Gender",

                onValueChange = {}

            )

            AppTextField(

                value = profile.bloodGroup,

                label = "Blood Group",

                onValueChange = {}

            )

            AppTextField(

                value = profile.dateOfBirth,

                label = "Date of Birth",

                onValueChange = {}

            )

            AppTextField(

                value = profile.address,

                label = "Address",

                onValueChange = {}

            )

            PrimaryButton(

                text = "Save",

                onClick = onSaveClick

            )

        }

    }

}