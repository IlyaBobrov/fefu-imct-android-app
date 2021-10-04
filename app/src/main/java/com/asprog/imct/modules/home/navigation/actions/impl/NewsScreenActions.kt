package com.asprog.imct.modules.home.navigation.actions.impl

import androidx.navigation.NavHostController
import com.asprog.imct.modules.home.navigation.nav.HomeNav

interface NewsScreenActions {

    val controller: NavHostController

    fun navigateToHome() {
        controller.navigate(HomeNav.MainNav.HomeScreen.route)
    }

}