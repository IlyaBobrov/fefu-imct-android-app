package com.asprog.imct.modules.info.navigation.graph

import android.util.Log
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.modules._common.navigation.NavActions
import com.asprog.imct.modules.info.navigation.nav.InfoNav
import com.asprog.imct.modules.info.ui.event.InfoEvents
import com.asprog.imct.modules.info.ui.screen.InfoScreen
import com.asprog.imct.modules.info.ui.viewmodel.InfoViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagingApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.infoScreenGraph(
    navActions: NavActions,
) {
    composable(route = InfoNav.MainNav.InfoScreen.route) {
        val viewModel: InfoViewModel = hiltViewModel()
        InfoScreen(viewModel = viewModel) { event ->
            when (event) {
                is InfoEvents.NavigateBack -> navActions.navigateToUp.invoke()
            }
        }
    }
}