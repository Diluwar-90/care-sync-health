package com.healthcare.patient.feature.profile.presentation.viewmodel


import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.profile.presentation.model.Profile
import com.healthcare.patient.feature.profile.presentation.state.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(

        ProfileUiState(

            profile = Profile(

                fullName = "Diluwar Hossain",

                email = "diluwar@example.com",

                phone = "+91 9876543210",

                gender = "Male",

                bloodGroup = "B+",

                dateOfBirth = "01 Jan 1990",

                address = "Hyderabad"

            )

        )

    )

    val uiState = _uiState.asStateFlow()

}