package com.healthcare.patient.ui.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.healthcare.patient.ui.theme.PatientappTheme

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    imageUrl: String? = null,
    size: Dp = 56.dp,
    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer
) {

    if (imageUrl.isNullOrBlank()) {

        Box(
            modifier = modifier
                .size(size)
                .clip(CircleShape)
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Avatar",
                tint = MaterialTheme.colorScheme.primary
            )

        }

    } else {

        AsyncImage(
            model = imageUrl,
            contentDescription = "Avatar",
            modifier = modifier
                .size(size)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun AvatarPreview() {

    PatientappTheme(){

        Avatar()

    }

}