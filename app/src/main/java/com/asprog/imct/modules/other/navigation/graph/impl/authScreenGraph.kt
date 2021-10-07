package com.asprog.imct.modules.other.navigation.graph.impl

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.modules._common.navigation.NavActions
import com.asprog.imct.modules.other.navigation.nav.OtherNav
import com.asprog.imct.modules.other.navigation.nav.impl.AuthNavScreen.SignInScreen
import com.asprog.imct.modules.other.ui.events.SignInEvents
import com.asprog.imct.modules.other.ui.screens.signIn.SignInScreen
import com.asprog.imct.modules.other.ui.viewModels.OtherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalMaterialApi
@ExperimentalPagingApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.authScreenGraph(
    navActions: NavActions,
) {
    composable(OtherNav.AuthNav.SignInScreen.route) {
        val baseViewModel = LocalBaseViewModel.current
        val viewModel: OtherViewModel = hiltViewModel()
        SignInScreen(viewModel = viewModel) { event ->
            when (event) {
                is SignInEvents.NavigateBack -> navActions.navigateToUp.invoke()
                is SignInEvents.SignIn -> viewModel.signIn(
                    event.login,
                    event.passw
                ) { accessToken, user ->
                    Log.d("TAG", "authScreenGraph: ")
                    baseViewModel.startUser(accessToken, user = user)
                    navActions.navigateToUp.invoke()
                }
            }
        }
    }
}