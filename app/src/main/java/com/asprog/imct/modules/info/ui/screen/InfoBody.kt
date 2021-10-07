package com.asprog.imct.modules.info.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.airbnb.lottie.compose.*
import com.asprog.imct.R
import com.asprog.imct.modules._common.ui.compose.LoadingScreen
import com.asprog.imct.modules.info.data.responses.InfoResponse
import com.asprog.imct.modules.info.data.state.InfoUiState
import com.asprog.imct.modules.info.ui.event.InfoEvents
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalCoilApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun InfoBody(
    uiState: InfoUiState,
    onEvent: (InfoEvents) -> Unit = {},
) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            elevation = AppBarDefaults.TopAppBarElevation,
            title = {
                Text(
                    text = stringResource(id = R.string.info_screen_bar),
                    fontSize = TextUnit.Unspecified,
                    color = MaterialTheme.colors.onPrimary
                )
            },
        )
    }) {
        InfoLoadingContent(
            empty = uiState.initialLoad,
            emptyContent = { LoadingScreen(uiState.loading) },
            loading = uiState.loading,
            content = {
                InfoScreenContentAndError(
                    data = uiState.data,
                    isShowError = uiState.errorMessages.isNotEmpty(),
                )
            }
        )
    }
}
