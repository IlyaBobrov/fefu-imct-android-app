package com.asprog.imct.extensions

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavController
import com.asprog.imct.base.LocalBaseViewModel

@Composable
fun NavController.AddChangeRouteListener() {
    Log.d("TAG", "AddChangeRouteListener: ")
    val localBaseViewModel = LocalBaseViewModel.current
    DisposableEffect(this) {
        Log.d("TAG", "DisposableEffect")
        val callback = NavController.OnDestinationChangedListener { controller, _, _ ->
            Log.d("TAG", "callback")
            controller.currentDestination?.route?.let { route ->
                Log.d("TAG", "currentDestination: ${route}")
                localBaseViewModel.setCurrentRoute(route)
            }
        }
        addOnDestinationChangedListener(callback)
        // remove the navController on dispose (i.e. when the composable is destroyed)
        onDispose {
            removeOnDestinationChangedListener(callback)
        }
    }
}