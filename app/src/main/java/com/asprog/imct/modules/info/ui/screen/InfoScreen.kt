package com.asprog.imct.modules.info.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.modules._common.ui.compose.ErrorNetworkScreen
import com.asprog.imct.modules.info.ui.event.InfoEvents
import com.asprog.imct.modules.info.ui.viewmodel.InfoViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagingApi
@ExperimentalComposeUiApi
@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun InfoScreen(
    viewModel: InfoViewModel,
    onEvent: (InfoEvents) -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsState()

    InfoBody(
        uiState = uiState,
        onEvent = onEvent,
    )

    if (uiState.isError) {
        ErrorNetworkScreen(uiState.loading)
    }
}