package com.asprog.imct.modules.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.asprog.imct.modules.home.services.apiService.ApiServiceHome
import com.asprog.imct.modules.home.services.data.DataServiceHome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeNewsViewModel
@Inject constructor(
    private val data: DataServiceHome,
    private val apiService: ApiServiceHome,
) : ViewModel() {

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

}