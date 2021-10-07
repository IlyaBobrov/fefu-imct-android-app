package com.asprog.imct.modules.other.navigation.actions.impl

import androidx.navigation.NavHostController
import com.asprog.imct.modules.other.navigation.nav.OtherNav

interface OnboardingScreenActions {

    val controller: NavHostController

    fun navigateToOnboarding() {
        controller.navigate(OtherNav.OnboardingNav.OnboardingScreen.route)
    }
}