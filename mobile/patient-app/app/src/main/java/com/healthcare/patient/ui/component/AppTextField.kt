package com.healthcare.patient.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.healthcare.patient.ui.theme.PatientappTheme


@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    isError: Boolean = false,
    supportingText: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingContent: (@Composable (() -> Unit))? = null,
    trailingContent: (@Composable (() -> Unit))? = null
) {

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),

        value = value,

        onValueChange = onValueChange,

        enabled = enabled,

        readOnly = readOnly,

        singleLine = singleLine,

        isError = isError,

        keyboardOptions = keyboardOptions,

        visualTransformation = visualTransformation,

        label = {
            Text(label)
        },

        placeholder = {

            if (placeholder.isNotBlank()) {

                Text(placeholder)

            }

        },

        leadingIcon = leadingContent,

        trailingIcon = trailingContent,

        supportingText = {

            supportingText?.let {

                Text(it)

            }

        },

        shape = MaterialTheme.shapes.medium,

        colors = OutlinedTextFieldDefaults.colors()

    )

}

@Preview(showBackground = true)
@Composable
private fun AppTextFieldPreview() {

    PatientappTheme() {

        AppTextField(
            value = "",
            onValueChange = {},
            label = "Full Name",
            placeholder = "Enter your full name"
        )

    }

}