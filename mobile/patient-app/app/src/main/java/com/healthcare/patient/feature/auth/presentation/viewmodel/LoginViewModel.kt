package com.healthcare.patient.feature.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.auth.presentation.state.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onMobileNumberChanged(number: String) {

        _uiState.value = _uiState.value.copy(
            mobileNumber = number
        )

    }

}