package com.asprog.imct.modules._common.service

sealed class ServerResult<out R> {
    data class Success<out T>(val data: T) : ServerResult<T>()
    data class Error(val exception: Exception) : ServerResult<Nothing>()
}

fun <T> ServerResult<T>.successOr(fallback: T): T {
    return (this as? ServerResult.Success<T>)?.data ?: fallback
}