package com.asprog.imct.modules.other.ui.screens.signIn


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import com.asprog.imct.modules.other.ui.events.SignInEvents
import com.asprog.imct.modules.other.ui.viewModels.OtherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun SignInScreen(
    viewModel: OtherViewModel,
    onEvent: (SignInEvents) -> Unit = {},
) {

    val loading: Boolean by viewModel.loading.collectAsState()
    val commonError: String? by viewModel.commonError.collectAsState(null)

    SignInBody(
        onEvent = onEvent,
        loading = loading,
        commonError = commonError,
    )
}
