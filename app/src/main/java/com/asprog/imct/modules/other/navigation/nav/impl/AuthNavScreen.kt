package com.asprog.imct.modules.other.navigation.nav.impl

import com.asprog.imct.base.NavScreen

object AuthNavScreen {
    val SignInScreen = object : NavScreen {
        override val route: String = "SignInScreen"
    }
}