package com.healthcare.patient.ui.component

import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.healthcare.patient.ui.theme.PatientappTheme

@Composable
fun PhoneTextField(
    phone: String,
    onPhoneChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    AppTextField(
        modifier = modifier.fillMaxWidth(),

        value = phone,

        onValueChange = {

            if (it.length <= 10 && it.all(Char::isDigit)) {

                onPhoneChange(it)

            }

        },

        label = "Mobile Number",

        placeholder = "9876543210",

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone
        ),

        leadingContent = {

            Text("+91")

        }

    )

}

@Preview(showBackground = true)
@Composable
private fun PhoneTextFieldPreview() {

    PatientappTheme() { }
        PhoneTextField(
            phone = "",
            onPhoneChange = {}
        )

    }