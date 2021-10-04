package com.asprog.imct.modules.home.ui.screen.homeScreen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.modules._common.ui.compose.ErrorNetworkScreen
import com.asprog.imct.modules.home.ui.events.HomeEvents
import com.asprog.imct.modules.home.ui.viewmodel.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onEvent: (HomeEvents) -> Unit = {},
) {

    val home by viewModel.getHome().collectAsState(false)
    val commonError: String? by viewModel.commonError.collectAsState()
    val loading: Boolean by viewModel.loading.collectAsState()

    HomeBody(
        home = home,
        commonError = commonError,
        loading = loading,
        onEvent = onEvent
    )

    if (viewModel.errorConnection.collectAsState().value) {
        ErrorNetworkScreen(loading)
    }

}

