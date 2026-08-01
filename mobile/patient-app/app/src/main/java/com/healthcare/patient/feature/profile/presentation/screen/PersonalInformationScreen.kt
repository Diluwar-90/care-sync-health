package com.healthcare.patient.feature.profile.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.profile.presentation.viewmodel.ProfileViewModel
import com.healthcare.patient.ui.component.AppToolbar
import com.healthcare.patient.ui.component.Avatar
import com.healthcare.patient.ui.component.PrimaryButton
import com.healthcare.patient.ui.dimens.AppDimens
import org.koin.androidx.compose.koinViewModel

@Composable
fun PersonalInformationScreen(

    onBackClick: () -> Unit,

    onEditProfileClick: () -> Unit,

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

            title = "Personal Information",

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

            Avatar()

            ProfileInfoItem(

                label = "Full Name",

                value = profile.fullName

            )

            ProfileInfoItem(

                label = "Mobile Number",

                value = profile.phone

            )

            ProfileInfoItem(

                label = "Email",

                value = profile.email

            )

            ProfileInfoItem(

                label = "Gender",

                value = profile.gender

            )

            ProfileInfoItem(

                label = "Blood Group",

                value = profile.bloodGroup

            )

            ProfileInfoItem(

                label = "Date of Birth",

                value = profile.dateOfBirth

            )

            ProfileInfoItem(

                label = "Address",

                value = profile.address

            )

            PrimaryButton(

                text = "Edit Profile",

                onClick = onEditProfileClick

            )

        }

    }

}

@Composable
private fun ProfileInfoItem(

    label: String,

    value: String

) {

    Column(

        verticalArrangement = Arrangement.spacedBy(
            AppDimens.Space4
        )

    ) {

        Text(

            text = label,

            style = MaterialTheme.typography.labelMedium

        )

        Text(

            text = value,

            style = MaterialTheme.typography.bodyLarge,

            fontWeight = FontWeight.Medium

        )

    }

}