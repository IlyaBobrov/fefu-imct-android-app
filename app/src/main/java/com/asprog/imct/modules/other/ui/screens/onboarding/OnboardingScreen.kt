package com.asprog.imct.modules.other.ui.screens.onboarding


import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.asprog.imct.modules.other.ui.events.StartEvents
import com.asprog.imct.modules.other.ui.viewModels.OtherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun OnboardingScreen(
    viewModel: OtherViewModel,
    onEvent: (StartEvents) -> Unit = {},
) {
    // Here variable initialization -> viewModel
    OnboardingBody(
        onEvent = onEvent,
    )
}
