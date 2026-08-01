package com.healthcare.patient.feature.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.healthcare.patient.core.datastore.PreferenceDataStore
import com.healthcare.patient.feature.auth.domain.usecase.VerifyOtpUseCase
import com.healthcare.patient.feature.auth.presentation.state.OtpUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OtpViewModel(
    private val verifyOtpUseCase: VerifyOtpUseCase,
    private val preferenceDataStore: PreferenceDataStore
) : ViewModel() {

    private val _uiState = MutableStateFlow(OtpUiState())
    val uiState = _uiState.asStateFlow()

    fun onOtpChanged(
        otp: String
    ) {

        _uiState.value = _uiState.value.copy(
            otp = otp
        )

    }

    fun verifyOtp() {
        viewModelScope.launch {
            // Using placeholder phone number as it's not passed yet in this flow
            val result = verifyOtpUseCase(
                phone = "9876543210",
                otp = _uiState.value.otp
            )

            if (result.isSuccess) {
                preferenceDataStore.setLoggedIn(true)
                _uiState.value = _uiState.value.copy(
                    isSuccess = true
                )
            }
        }
    }

}
