package com.healthcare.patient.feature.onboarding.presentation.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        repeat(pageCount) { index ->

            val selected = index == currentPage

            val width by animateDpAsState(
                targetValue = if (selected) 28.dp else 10.dp,
                label = "IndicatorWidth"
            )

            val color by animateColorAsState(
                targetValue =
                    if (selected)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.outline.copy(alpha = 0.4f),
                label = "IndicatorColor"
            )

            Box(
                modifier = Modifier
                    .width(width)
                    .size(height = 10.dp, width = width)
                    .clip(RoundedCornerShape(50))
                    .background(color)
            )

        }

    }

}