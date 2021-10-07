package com.asprog.imct.modules._common.navigation

import androidx.navigation.NavHostController
import com.asprog.imct.modules.home.navigation.actions.HomeNavActions
import com.asprog.imct.modules.info.navigation.action.InfoNavActions
import com.asprog.imct.modules.other.navigation.actions.OtherNavActions
import com.asprog.imct.modules.profile.navigation.action.ProfileNavActions

class NavActions(
    override val controller: NavHostController,
) : HomeNavActions,
    InfoNavActions,
    ProfileNavActions,
    OtherNavActions {

    val navigateToUp: () -> Unit = {
        controller.navigateUp()
    }

}