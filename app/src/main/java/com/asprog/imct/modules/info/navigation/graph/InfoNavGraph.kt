package com.asprog.imct.modules.info.navigation.graph

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.modules._common.navigation.NavActions
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagingApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.infoNavGraph(
    navActions: NavActions,
) {
    infoScreenGraph(navActions)
}