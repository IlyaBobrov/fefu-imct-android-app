package com.asprog.imct.modules._common.navigation

import androidx.navigation.NavHostController
import com.asprog.imct.modules.profile.navigation.action.ProfileNavActions
import com.asprog.imct.modules.home.navigation.actions.HomeNavActions
import com.asprog.imct.modules.info.navigation.action.InfoNavActions

class NavActions(
    override val controller: NavHostController,
) : HomeNavActions,
    InfoNavActions,
    ProfileNavActions {

    val navigateToUp: () -> Unit = {
        controller.navigateUp()
    }

}