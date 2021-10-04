package com.asprog.imct.modules.info.navigation.action

import androidx.navigation.NavHostController
import com.asprog.imct.modules.info.navigation.nav.InfoNav

interface InfoScreenActions {
    val controller: NavHostController
    fun navigateToInfo() {
        controller.navigate(InfoNav.MainNav.InfoScreen.route)
    }
}