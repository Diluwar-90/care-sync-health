package com.healthcare.patient.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.healthcare.patient.ui.theme.PatientappTheme

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Search...",
    enabled: Boolean = true,
    onClearClick: () -> Unit = {
        onQueryChange("")
    }
) {

    AppTextField(
        modifier = modifier.fillMaxWidth(),

        value = query,

        onValueChange = onQueryChange,

        label = "Search",

        placeholder = placeholder,

        enabled = enabled,

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),

        leadingContent = {

            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search"
            )

        },

        trailingContent = {

            if (query.isNotEmpty()) {

                IconButton(
                    onClick = onClearClick
                ) {

                    Icon(
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = "Clear"
                    )

                }

            }

        }

    )

}

@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {

    PatientappTheme() {

        SearchBar(
            query = "",
            onQueryChange = {}
        )

    }

}