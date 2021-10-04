package com.asprog.imct.modules.info.data.state

import androidx.annotation.StringRes
import com.asprog.imct.modules.info.data.responses.InfoResponse

data class InfoUiState(
    val data: InfoResponse? = null,
    val loading: Boolean = false,
    val errorMessages: List<ErrorMessage> = emptyList(),
    val isError: Boolean = false
) {
    val initialLoad: Boolean
        get() = data == null && errorMessages.isEmpty() && loading
}

data class ErrorMessage(val id: Long, @StringRes val messageId: Int)