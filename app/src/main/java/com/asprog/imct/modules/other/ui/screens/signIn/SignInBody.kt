package com.asprog.imct.modules.other.ui.screens.signIn


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.asprog.imct.R
import com.asprog.imct.extensions.sizeLarge
import com.asprog.imct.modules._common.ui.compose.FormError
import com.asprog.imct.modules._common.ui.compose.MainScaffoldSearch
import com.asprog.imct.modules._common.ui.compose.TopBarContentTitle
import com.asprog.imct.modules.other.ui.events.SignInEvents

@ExperimentalComposeUiApi
@Composable
fun SignInBody(
    loading: Boolean = false,
    commonError: String? = null,
    onEvent: (SignInEvents) -> Unit = {},
) {
    MainScaffoldSearch(
        contentLoadState = loading,
        contentTitle = {
            TopBarContentTitle(stringResource(id = R.string.sign_in_title))
        },
        navigationIcon = Icons.Filled.ArrowBack,
        navigationIconOnClick = {
            onEvent(SignInEvents.NavigateBack)
        }
    ) {

        val padding = 16.dp
        val listState = rememberScrollState()

        Column(
            modifier = Modifier
                .padding(start = padding, end = padding)
                .background(MaterialTheme.colors.background)
                .verticalScroll(listState)
        ) {

            Spacer(modifier = Modifier.sizeLarge())

            // common error
            commonError?.let {
                FormError(textError = it)
                Spacer(Modifier.size(padding))
                LaunchedEffect(commonError) { listState.animateScrollTo(0) }
            }

            SignInForm(
                loading = loading,
                onNavigationEvent = onEvent
            )

            Spacer(modifier = Modifier.sizeLarge())
        }
    }
}


