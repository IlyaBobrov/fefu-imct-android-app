package com.asprog.imct

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnPreDrawListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.modules._common.navigation.NavGraph
import com.asprog.imct.modules._common.ui.viewmodels.MainViewModel
import com.asprog.imct.modules.home.navigation.nav.HomeNav
import com.asprog.imct.ui.theme.MyTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavHostController

    @ExperimentalMaterialApi
    @ExperimentalCoilApi
    @ExperimentalPagingApi
    @ExperimentalPagerApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            CompositionLocalProvider(LocalBaseViewModel provides viewModel) {
                MyTheme {

                    this@MainActivity.window.statusBarColor =
                        MaterialTheme.colors.primaryVariant.toArgb()

                    NavGraph(navController)
                }
            }
        }
        // Splash delay
        window.decorView.findViewById<View>(android.R.id.content)?.let { content ->
            content.viewTreeObserver.addOnPreDrawListener(
                object : OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        return if (viewModel.isReady.value) {
                            // remove BG splash
                            this@MainActivity.window.decorView.setBackgroundColor(Color.BLUE)
                            // done splash remove listener
                            content.viewTreeObserver.removeOnPreDrawListener(this); true
                        } else false
                    }
                }
            )
        }
    }

    override fun onBackPressed() {
        when (navController.currentDestination?.route) {
            HomeNav.MainNav.HomeScreen.route ->
                viewModel.apply { if (showSnackBar.value) finishAffinity() else toggleSnackBar() }
            else -> super.onBackPressed()
        }
    }
}
