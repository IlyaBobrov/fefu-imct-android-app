package com.asprog.imct.modules.profile.ui.screen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.modules._common.ui.compose.ErrorNetworkScreen
import com.asprog.imct.modules.profile.ui.event.ProfileEvents
import com.asprog.imct.modules.profile.ui.viewmodel.ProfileViewModel
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalMaterialApi
@ExperimentalPagingApi
@ExperimentalComposeUiApi
@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onEvent: (ProfileEvents) -> Unit = {},
) {
    val user by viewModel.getUser().collectAsState(false)
    val loading: Boolean by viewModel.loading.collectAsState()
    val isLogin by LocalBaseViewModel.current.isLogin.collectAsState()
    val userResp by LocalBaseViewModel.current.userResp.collectAsState()


    ProfileBody(
        user = user,
        loading = loading,
        isLogin = isLogin,
        userResp = userResp,
        onEvent = onEvent,
    )

    if (viewModel.errorConnection.collectAsState().value) {
        ErrorNetworkScreen(loading)
    }
}