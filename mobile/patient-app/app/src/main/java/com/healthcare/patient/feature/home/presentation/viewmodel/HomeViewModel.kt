package com.healthcare.patient.feature.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.home.presentation.state.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onSearchChanged(text: String) {

        _uiState.value = _uiState.value.copy(
            searchText = text
        )

    }

}