package com.asprog.imct.modules._common.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.ImportContacts
import androidx.compose.ui.graphics.vector.ImageVector
import com.asprog.imct.R
import com.asprog.imct.modules.profile.navigation.nav.ProfileNav
import com.asprog.imct.modules.home.navigation.nav.HomeNav
import com.asprog.imct.modules.info.navigation.nav.InfoNav

enum class HomeTab(
    val route: String,
    val icon: ImageVector,
    @StringRes val label: Int
) {

    HOME(HomeNav.MainNav.HomeScreen.route, Icons.Filled.Article, R.string.menu_home),
    INFO(InfoNav.MainNav.InfoScreen.route, Icons.Filled.ImportContacts, R.string.menu_info),
    PROFILE(
        ProfileNav.MainNav.ProfileScreen.route,
        Icons.Filled.AccountCircle,
        R.string.menu_cabinet
    );

    companion object {
        fun String.findByRoute(): HomeTab? {
            return when (this) {
                HOME.route -> HOME
                INFO.route -> INFO
                PROFILE.route -> PROFILE
                else -> null
            }
        }
    }
}