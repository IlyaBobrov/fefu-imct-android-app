package com.asprog.imct.modules.home.navigation.nav.impl

import com.asprog.imct.base.NavScreen

object HomeNavScreen {

    val HomeScreen = object : NavScreen {
        override val route: String = "HomeScreen"
    }

    val SingleNewsScreen = object : NavScreen {
        override val route: String = "SingleNewsScreen"
    }

}