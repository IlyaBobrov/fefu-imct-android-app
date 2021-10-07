package com.asprog.imct.modules.other.navigation.graph.impl

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.modules._common.navigation.NavActions
import com.asprog.imct.modules.other.navigation.nav.OtherNav
import com.asprog.imct.modules.other.navigation.nav.impl.OnboardingNavScreen.OnboardingScreen
import com.asprog.imct.modules.other.ui.events.StartEvents
import com.asprog.imct.modules.other.ui.screens.onboarding.OnboardingScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.onboardingScreenGraph(
    navActions: NavActions,
) {
    composable(OtherNav.OnboardingNav.OnboardingScreen.route) {
        val baseViewModel = LocalBaseViewModel.current
        OnboardingScreen(viewModel = hiltViewModel()) { event ->
            when (event) {
                is StartEvents.NavigateToBrands -> {
                    baseViewModel.startPageCompleted()
//                    navActions.navigateToBrands()
                }
            }
        }
    }
}