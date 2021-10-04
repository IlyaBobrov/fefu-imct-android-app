package com.asprog.imct.modules.home.navigation.graph.impl

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.asprog.imct.modules._common.navigation.NavActions
import com.asprog.imct.modules.home.navigation.nav.HomeNav
import com.asprog.imct.modules.home.ui.events.HomeEvents
import com.asprog.imct.modules.home.ui.screen.homeScreen.HomeScreen
import com.asprog.imct.modules.home.ui.viewmodel.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
fun NavGraphBuilder.homeScreenGraph(
    navActions: NavActions,
) {
    composable(
        route = HomeNav.MainNav.HomeScreen.route,
    ) {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(viewModel = hiltViewModel()) { event ->
            when (event) {
                is HomeEvents.RefreshHome -> viewModel.updateHome()
                is HomeEvents.NavigateBack -> navActions.navigateToUp.invoke()
//                is HomeEvents.NavigateToNews -> navActions.navigateToNews()
//                is HomeEvents.NewsSingleData -> navActions.navigateToNewsWithTitle(event.title)
//                is HomeEvents.NavigateToNewsWithArg -> navActions.navigateToNewsWithArg(event.title, event.desc, event.image, event.author)
                is HomeEvents.NavigateToNewsWithArg -> navActions.navigateToNewsWithArgs(event.title, event.description, event.image, event.author)
            }
        }
    }



}