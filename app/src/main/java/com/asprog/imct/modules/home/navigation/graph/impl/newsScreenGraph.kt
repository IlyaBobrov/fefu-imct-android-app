package com.asprog.imct.modules.home.navigation.graph.impl

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.asprog.imct.modules._common.navigation.NavActions
import com.asprog.imct.modules.home.navigation.nav.HomeNav
import com.asprog.imct.modules.home.ui.events.NewsEvents
import com.asprog.imct.modules.home.ui.screen.newsScreen.NewsScreen
import com.asprog.imct.modules.home.ui.viewmodel.HomeNewsViewModel

@SuppressLint("LogNotTimber")
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
fun NavGraphBuilder.newsScreenGraph(
    navActions: NavActions,
) {
    composable(
        route = HomeNav.NewsNav.NewsScreen.routeWithArgument,
        arguments = listOf(
            navArgument(HomeNav.NewsNav.NewsScreen.argument0) {
                type = NavType.StringType; nullable = true
            },
            navArgument(HomeNav.NewsNav.NewsScreen.argument1) {
                type = NavType.StringType; nullable = true
            },
            navArgument(HomeNav.NewsNav.NewsScreen.argument2) {
                type = NavType.StringType; nullable = true
            },
            navArgument(HomeNav.NewsNav.NewsScreen.argument3) {
                type = NavType.StringType; nullable = true
            }
        )
    ) { backStackEntry ->
        Log.d("TAG", "newsScreenGraph: ${backStackEntry.arguments}")
        val viewModel: HomeNewsViewModel = hiltViewModel()
        backStackEntry.arguments?.let{
            NewsScreen(
                viewModel = viewModel,
                argumentTitle = it.getString(HomeNav.NewsNav.NewsScreen.argument0),
                argumentDescription = it.getString(HomeNav.NewsNav.NewsScreen.argument1),
                argumentImages = it.getString(HomeNav.NewsNav.NewsScreen.argument2),
                argumentCreator = it.getString(HomeNav.NewsNav.NewsScreen.argument3),
                onEvent = { event ->
                    when (event) {
                        is NewsEvents.NavigateBack -> navActions.navigateToUp()
                    }
                }
            )
        }
    }
}