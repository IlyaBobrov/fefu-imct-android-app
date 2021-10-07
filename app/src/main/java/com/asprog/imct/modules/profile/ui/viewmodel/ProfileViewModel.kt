package com.asprog.imct.modules.profile.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asprog.imct.base.done
import com.asprog.imct.base.error
import com.asprog.imct.base.errorUnknownHost
import com.asprog.imct.base.success
import com.asprog.imct.modules._common.data.UserModel
import com.asprog.imct.modules.profile.services.apiService.ApiServiceProfile
import com.asprog.imct.modules.profile.services.data.DataServiceProfile
import com.asprog.imct.urils.DebugLocalData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val data: DataServiceProfile,
    private val apiService: ApiServiceProfile,
) : ViewModel() {

    private val _errorConnection: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val errorConnection: StateFlow<Boolean> get() = _errorConnection.asStateFlow()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    fun userUpdate() {
        _loading.value = true
        viewModelScope.launch {
            if (true/*DebugLocalData*/) {
//                data.updateUser()
            } else {
                apiService.getUser()
                    .success { response ->
                        data.updateUser(response)
                    }
                    .error {
                        Timber.e(it)
                    }
                    .done {
                        delay(500) // disable loading after insert
                        _loading.value = false
                        _errorConnection.value = false
                    }
                    .errorUnknownHost {
                        _errorConnection.value = true
                    }
            }

        }
    }

    fun getUser(): Flow<UserModel?> {
        return data.getUser().distinctUntilChanged()
    }

}