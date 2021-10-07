package com.asprog.imct.modules.info.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asprog.imct.R
import com.asprog.imct.modules._common.service.ServerResult
import com.asprog.imct.modules.info.data.mock.MockInfoResponse
import com.asprog.imct.modules.info.data.state.ErrorMessage
import com.asprog.imct.modules.info.data.state.InfoUiState
import com.asprog.imct.modules.info.repository.InfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class InfoViewModel
@Inject constructor(
    private val repository: InfoRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(InfoUiState(loading = true))
    val uiState: StateFlow<InfoUiState> = _uiState.asStateFlow()

    init {
        initInfo()
    }

    private fun initInfo() {
        _uiState.update { it.copy(loading = true) }
        viewModelScope.launch {
            val result = MockInfoResponse
            _uiState.update {
                it.copy(data = result, loading = false)
                /*when (result) {
                    is ServerResult.Success -> {
                        it.copy(data = result.data, loading = false)
                    }
                    is ServerResult.Error -> {
                        val errorMessages = it.errorMessages + ErrorMessage(
                            id = UUID.randomUUID().mostSignificantBits,
                            messageId = R.string.load_error
                        )
                        it.copy(errorMessages = errorMessages, loading = false)
                    }
                }*/
            }
        }
    }

}