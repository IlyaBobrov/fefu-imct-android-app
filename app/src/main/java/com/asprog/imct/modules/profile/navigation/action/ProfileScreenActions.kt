package com.asprog.imct.modules.profile.navigation.action

import androidx.navigation.NavHostController
import com.asprog.imct.modules.profile.navigation.nav.ProfileNav

interface ProfileScreenActions {
    val controller: NavHostController
    fun navigateToProfile() {
        controller.navigate(ProfileNav.MainNav.ProfileScreen.route)
    }
}