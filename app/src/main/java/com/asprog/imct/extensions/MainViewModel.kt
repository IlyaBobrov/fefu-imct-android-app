package com.asprog.imct.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.asprog.imct.modules._common.ui.viewmodels.MainViewModel

@Composable
fun MainViewModel.ListenRefresh(listener: (route: String) -> Unit) {
    val refresh by toggleRefresh.collectAsState()
    LaunchedEffect(refresh) {
        if (refresh) {
            listener.invoke(route.value)
        }
    }
}