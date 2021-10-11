package com.asprog.imct.modules.home.ui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asprog.imct.base.done
import com.asprog.imct.base.error
import com.asprog.imct.base.errorUnknownHost
import com.asprog.imct.base.success
import com.asprog.imct.modules._common.data.mockData.HomeModelMock
import com.asprog.imct.modules.home.data.relations.HomeRelation
import com.asprog.imct.modules.home.services.apiService.ApiServiceHome
import com.asprog.imct.modules.home.services.data.DataServiceHome
import com.asprog.imct.urils.ConstantsPaging
import com.asprog.imct.urils.DebugLocalData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val data: DataServiceHome,
    private val apiService: ApiServiceHome,
) : ViewModel() {

    private val _errorConnection: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val errorConnection: StateFlow<Boolean> get() = _errorConnection.asStateFlow()

    private val _commonError: MutableStateFlow<String?> = MutableStateFlow(null)
    val commonError: StateFlow<String?> get() = _commonError.asStateFlow()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    init {
        if (!DebugLocalData) {
            updateHome()
        } else {
            if (System.currentTimeMillis() - data.preferences.lastUpdateHome >= ConstantsPaging.CACHE_TIMEOUT) {
                updateHome()
            }
        }
    }

    @SuppressLint("LogNotTimber")
    fun updateHome() {
        Log.d("TAG", "updateHome: ")
        data.preferences.lastUpdateHome = System.currentTimeMillis()
        // start update
        _commonError.value = null
        _loading.value = true
        // make a request
        viewModelScope.launch {
            if (DebugLocalData) {
                /**mock - error*/
//                delay(500)
//                _loading.value = false
//                _commonError.value = "Error update home"
//                _errorConnection.value = true
                /**mock - true*/
                data.clear()
                delay(1000)
                data.insert(HomeModelMock.data)
                delay(500) // disable loading after insert
                _loading.value = false
                _errorConnection.value = false
            } else {
                Log.d("TAG", "updateHome: getHome")
                apiService.getHome()
                    .success { response ->
                        Log.e("TAG", "updateHome: success", )
                        // clear old data
                        data.clear()
                        // insert if not null
                        response?.let {
                            data.insert(it)
                        }
                    }
                    .error {
                        Log.e("TAG", "updateHome: error", )
                        Timber.e(it)
                        _commonError.value = it.message ?: "Error update feed"
                    }
                    .done {
                        Log.e("TAG", "updateHome: done", )
                        delay(500) // disable loading after insert
                        _loading.value = false
                        _errorConnection.value = false
                    }
                    .errorUnknownHost {
                        Log.e("TAG", "updateHome: errorUnknownHost", )
                        _errorConnection.value = true
                    }
            }
        }
    }


    fun getHome(): Flow<HomeRelation?> {
        return data.getHomeRelation().distinctUntilChanged()
    }


}