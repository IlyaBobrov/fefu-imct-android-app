package com.asprog.imct.modules.profile.navigation.graph

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.modules._common.navigation.NavActions
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagingApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.profileNavGraph(
    navActions: NavActions,
) {
    profileScreenGraph(navActions)
}