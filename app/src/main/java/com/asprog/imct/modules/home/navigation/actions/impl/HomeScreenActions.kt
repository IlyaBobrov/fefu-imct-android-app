package com.asprog.imct.modules.home.navigation.actions.impl

import androidx.navigation.NavHostController
import com.asprog.imct.modules.home.navigation.nav.HomeNav

interface HomeScreenActions {

    val controller: NavHostController

    fun navigateToNewsWithArgs(title: String, description: String, images: String, author: String) {
        controller.navigate(
            HomeNav.NewsNav.NewsScreen.getRoute(
                argument0 = title,
                argument1 = description,
                argument2 = images,
                argument3 = author
            )
        )
    }

}