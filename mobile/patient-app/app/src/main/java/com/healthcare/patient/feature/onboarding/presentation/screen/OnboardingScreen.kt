package com.healthcare.patient.feature.onboarding.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.healthcare.patient.feature.onboarding.presentation.model.OnboardingData
import com.healthcare.patient.feature.onboarding.presentation.component.OnboardingPageItem
import com.healthcare.patient.feature.onboarding.presentation.component.PagerIndicator
import com.healthcare.patient.ui.component.PrimaryButton
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.healthcare.patient.feature.onboarding.presentation.viewmodel.OnboardingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnboardingScreen(
    onNavigateToLogin: () -> Unit,
    viewModel: OnboardingViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val pages = OnboardingData.pages

    val pagerState = rememberPagerState(
        pageCount = { pages.size }
    )

    val scope = rememberCoroutineScope()

    LaunchedEffect(pagerState.currentPage) {

        viewModel.onPageChanged(
            page = pagerState.currentPage
        )

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {

        if (!uiState.isLastPage) {

            TextButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp),
                onClick = {
                    onNavigateToLogin()
                }
            ) {

                Text("Skip")

            }

        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            HorizontalPager(
                modifier = Modifier.weight(1f),
                state = pagerState,
                contentPadding = PaddingValues(0.dp)
            ) { page ->

                OnboardingPageItem(
                    page = pages[page]
                )

            }

            PagerIndicator(
                pageCount = pages.size,
                currentPage = pagerState.currentPage,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = if (uiState.isLastPage) "Get Started" else "Next",
                onClick = {

                    if (uiState.isLastPage) {

                        viewModel.completeOnboarding()

                        onNavigateToLogin()

                    } else {

                        scope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage + 1
                            )
                        }

                    }

                }
            )

        }

    }

}