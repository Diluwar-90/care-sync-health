package com.healthcare.patient.feature.home.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.healthcare.patient.ui.component.SearchBar

@Composable
fun SearchSection(
    searchText: String,
    onSearchChange: (String) -> Unit
) {

    SearchBar(
        modifier = Modifier.fillMaxWidth(),
        query = searchText,
        onQueryChange = onSearchChange,
        placeholder = "Search doctors, hospitals..."
    )

}