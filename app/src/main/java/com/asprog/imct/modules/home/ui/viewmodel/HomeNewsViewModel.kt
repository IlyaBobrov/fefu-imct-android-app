package com.asprog.imct.modules.home.ui.viewmodel

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
class HomeNewsViewModel
@Inject constructor(
    private val data: DataServiceHome,
    private val apiService: ApiServiceHome,
) : ViewModel() {

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

}