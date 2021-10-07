package com.asprog.imct.modules._common.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.extensions.AddChangeRouteListener
import com.asprog.imct.modules._common.navigation.HomeTab.Companion.findByRoute
import com.asprog.imct.modules._common.ui.compose.BottomBar
import com.asprog.imct.modules.profile.navigation.graph.profileNavGraph
import com.asprog.imct.modules.home.navigation.graph.homeNavGraph
import com.asprog.imct.modules.home.navigation.nav.HomeNav
import com.asprog.imct.modules.info.navigation.graph.infoNavGraph
import com.asprog.imct.modules.other.navigation.graph.otherNavGraph
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalPagingApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun NavGraph(navController: NavHostController) {
    val baseViewModel = LocalBaseViewModel.current

    navController.AddChangeRouteListener()

    val navActions = remember(navController) {
        NavActions(navController)
    }

    ProvideWindowInsets {
        val scaffoldState = rememberScaffoldState()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: HomeNav.MainNav.HomeScreen.route

        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = currentRoute.findByRoute()?.let { homeTab ->
                {
                    BottomBar(
                        currentRoute = homeTab,
                        navActions = navActions
                    )
                }
            } ?: run { {} },
        ) {
            Box(
                modifier = Modifier.padding(it)
            ) {
                NavHost(navController = navController,
                    startDestination = baseViewModel.getStartRoute()) {
                    homeNavGraph(
                        navActions = navActions,
                    )
                    infoNavGraph(
                        navActions = navActions,
                    )
                    otherNavGraph(
                        navActions = navActions,
                    )
                    profileNavGraph(
                        navActions = navActions,
                    )
                }
            }
        }
    }
}
