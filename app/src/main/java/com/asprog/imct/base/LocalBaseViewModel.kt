package com.asprog.imct.base

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.staticCompositionLocalOf
import com.asprog.imct.modules._common.ui.viewmodels.MainViewModel

val LocalBaseViewModel = staticCompositionLocalOf<MainViewModel> {
    Log.e("TAG", "LocalBaseViewModel: No MainViewModel found!")
    error("No MainViewModel found!")
}