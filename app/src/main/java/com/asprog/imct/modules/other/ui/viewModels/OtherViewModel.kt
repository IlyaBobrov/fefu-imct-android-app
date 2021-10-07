package com.asprog.imct.modules.other.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asprog.imct.base.done
import com.asprog.imct.base.error
import com.asprog.imct.base.success
import com.asprog.imct.modules.other.data.resp.UserResp
import com.asprog.imct.modules.other.service.apiService.ApiServiceOther
import com.asprog.imct.modules.other.service.data.DataServiceOther
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    private val data: DataServiceOther,
    private val apiService: ApiServiceOther,
) : ViewModel() {

    private val _commonError: MutableStateFlow<String?> = MutableStateFlow(null)
    val commonError: StateFlow<String?> get() = _commonError.asStateFlow()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    fun signIn(
        login: String,
        passw: String,
        success: (accessToken: String, user: UserResp) -> Unit,
    ) {
        _commonError.value = null
        _loading.value = true
        viewModelScope.launch {
            apiService.signIn(login = login, passw = passw)
                .done { _loading.value = false }
                .success {
                    Log.d("TAG", "signIn: ")
                    val user = UserResp(
                        it.user?.id ?: -1,
                        it.user?.name ?: "",
                        it.user?.email ?: "",
                        it.user?.role ?: -1,
                        )
                    success.invoke(it.access_token ?: "error", user)
                }
                .error { _commonError.value = it.message ?: "Authentication failed"; Timber.e(it) }
        }
    }
}
