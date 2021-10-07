package com.asprog.imct.modules.profile.navigation.graph

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.modules._common.navigation.NavActions
import com.asprog.imct.modules.profile.navigation.nav.ProfileNav
import com.asprog.imct.modules.profile.ui.event.ProfileEvents
import com.asprog.imct.modules.profile.ui.screen.ProfileScreen
import com.asprog.imct.modules.profile.ui.viewmodel.ProfileViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagingApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.profileScreenGraph(
    navActions: NavActions,
) {
    composable(ProfileNav.MainNav.ProfileScreen.route) {
        val viewModel: ProfileViewModel = hiltViewModel()
        val baseViewModel = LocalBaseViewModel.current
        ProfileScreen(viewModel = viewModel) { event ->
            when (event) {
                is ProfileEvents.NavigateBack -> navActions.navigateToUp.invoke()
                is ProfileEvents.NavigateToSignIn -> navActions.navigateToSignIn()
                is ProfileEvents.NavigateLogout -> baseViewModel.logout()

            }
        }
    }
}