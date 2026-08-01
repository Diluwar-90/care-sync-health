package com.healthcare.patient.feature.splash.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.healthcare.patient.R

@Composable
fun Logo(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primaryContainer,
        tonalElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_healthcare_logo),
            contentDescription = "Healthcare Logo",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LogoPreview() {
    Logo()
}