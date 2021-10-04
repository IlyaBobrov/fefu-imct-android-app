package com.asprog.imct.modules._common.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules._common.service.DataServiceCommon
import com.asprog.imct.modules.home.navigation.nav.HomeNav
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val data: DataServiceCommon,
    private val preferences: AppPreferences,
): ViewModel() {

    private val _toggleRefresh: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val toggleRefresh: StateFlow<Boolean> get() = _toggleRefresh.asStateFlow()

    private val _isReady: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> get() = _isReady.asStateFlow()

    private val _isLogin: MutableStateFlow<Boolean> = MutableStateFlow(preferences.isLogin())
    val isLogin: StateFlow<Boolean> get() = _isLogin.asStateFlow()

    private val _showSnackBar: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showSnackBar: StateFlow<Boolean> get() = _showSnackBar.asStateFlow()

    private val _route: MutableStateFlow<String> = MutableStateFlow("")
    val route: StateFlow<String> get() = _route.asStateFlow()


    init {
        viewModelScope.launch {
            delay(500)

            Timber.d("User token -> ${preferences.accessToken}")

            _isReady.value = true
        }
    }

    fun toggleSnackBar() {
        _showSnackBar.value = true
        viewModelScope.launch {
            delay(1500) // Loading second click
            _showSnackBar.value = false
        }
    }

    fun listRefresh() {
        _toggleRefresh.value = true
        viewModelScope.launch {
            delay(1000)
            _toggleRefresh.value = false
        }
    }

    // TODO: 29.09.2021 start page
    fun getStartRoute(): String {
        /*return if (preferences.isStartPage) {
            OtherNav.OnboardingNav.OnboardingScreen.route
        } else {*/
           return HomeNav.MainNav.HomeScreen.route
//        }
    }

    fun setCurrentRoute(route: String) {
        if (route != _route.value) {
            _route.value = route
        }
    }

    // TODO: 29.09.2021 start page
    fun startPageCompleted() {
        preferences.isStartPage = false
    }

    fun startUser(accessToken: String, refreshToken: String) {
        _isLogin.value = true
        // update credentials
        preferences.setTokens(accessToken, refreshToken)
    }

    fun logout() {
        _isLogin.value = false
        // clear preferences
        preferences.clearAfterLogout()
        // clear preferences
        viewModelScope.launch {
            data.clearAfterLogout()
        }
    }

}