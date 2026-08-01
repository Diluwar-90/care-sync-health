package com.healthcare.patient.feature.splash.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.healthcare.patient.core.base.BaseViewModel
import com.healthcare.patient.core.datastore.PreferenceDataStore
import com.healthcare.patient.feature.onboarding.domain.usecase.GetOnboardingStatusUseCase
import com.healthcare.patient.feature.splash.presentation.state.SplashUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashViewModel(
    private val getOnboardingStatusUseCase: GetOnboardingStatusUseCase,
    private val preferenceDataStore: PreferenceDataStore
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(SplashUiState())
    val uiState = _uiState.asStateFlow()

    init {
        checkStatus()
    }

    private fun checkStatus() {

        viewModelScope.launch {

            delay(2000)

            val isCompleted =
                getOnboardingStatusUseCase().first()

            val isLoggedIn = preferenceDataStore.isLoggedIn.first()

            _uiState.value = SplashUiState(
                isLoading = false,
                isOnboardingCompleted = isCompleted,
                isLoggedIn = isLoggedIn
            )

        }

    }

}
