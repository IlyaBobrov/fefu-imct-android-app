package com.asprog.imct.modules.other.navigation.actions.impl

import androidx.navigation.NavHostController
import com.asprog.imct.modules.other.navigation.nav.OtherNav

interface AuthScreenActions {

    val controller: NavHostController

    fun navigateToSignIn() {
        controller.navigate(OtherNav.AuthNav.SignInScreen.route)
    }
}