package com.healthcare.patient.feature.family.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.healthcare.patient.feature.family.presentation.model.FamilyMember
import com.healthcare.patient.feature.family.presentation.state.FamilyUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FamilyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(

        FamilyUiState(

            members = listOf(

                FamilyMember(
                    id = 1,
                    name = "Huzaifa",
                    relation = "Son",
                    age = 5,
                    bloodGroup = "B+"
                ),

                FamilyMember(
                    id = 2,
                    name = "Wife",
                    relation = "Spouse",
                    age = 30,
                    bloodGroup = "O+"
                )

            )

        )

    )

    val uiState = _uiState.asStateFlow()

}