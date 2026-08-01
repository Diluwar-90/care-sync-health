package com.healthcare.patient.feature.onboarding.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.healthcare.patient.core.base.BaseViewModel
import com.healthcare.patient.feature.onboarding.domain.usecase.CompleteOnboardingUseCase
import com.healthcare.patient.feature.onboarding.presentation.state.OnboardingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val completeOnboardingUseCase: CompleteOnboardingUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    fun onPageChanged(page: Int) {

        _uiState.value = _uiState.value.copy(
            currentPage = page,
            isLastPage = page == 2
        )

    }

    fun completeOnboarding() {
        viewModelScope.launch {
            completeOnboardingUseCase()
        }
    }

}