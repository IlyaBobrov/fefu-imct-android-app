package com.asprog.imct.base

import androidx.paging.PagingSource
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Response
import java.net.UnknownHostException

sealed class ResponseResult<out R> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Error(val exception: Exception) : ResponseResult<Nothing>()
}

object LocalTryExecuteWithResponse {

    private val _tryExecuteWithResponse: MutableSharedFlow<Exception> = MutableSharedFlow(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val current: SharedFlow<Exception> get() = _tryExecuteWithResponse.asSharedFlow()

    fun tryEmit(exception: Exception) {
        _tryExecuteWithResponse.tryEmit(exception)
    }

    inline fun <T> executeWithResponse(body: () -> T): ResponseResult<T> {
        return try {
            ResponseResult.Success(body.invoke())
        } catch (e: Exception) {
            tryEmit(e)
            ResponseResult.Error(e)
        }
    }
}


private fun <T> Response<T>.getStringBody(): String {
    return this.errorBody()?.string() ?: this.body().toString()
}

private fun String.parseApiError(): String? {
    return try {
        // fix for app
        val data = if (startsWith("{") && JSONObject(this).has("errors")) {
            JSONObject(this).getJSONArray("errors").toString()
        } else {
            this
        }
        // get json object
        val obj = if (data.startsWith("[")) {
            val arr = JSONArray(data)
            if (arr.length() == 0) throw Exception()
            arr.getJSONObject(0)
        } else {
            JSONObject(data)
        }
        // get message
        return if (obj.has("message")) {
            obj.getString("message")
        } else throw Exception()
    } catch (ex: Exception) {
        null
    }
}

sealed class HTTPResult(val code: Int, error: String) : RuntimeException(error) {
    object Result200 : HTTPResult(200, "OK")
    class Result400(error: String = "Bad Request") : HTTPResult(400, error)
    class Result401(error: String = "Unauthorized") : HTTPResult(401, error)
    class Result403(error: String = "Forbidden") : HTTPResult(403, error)
    class Result404(error: String = "Not Found") : HTTPResult(404, error)
    class Result500(error: String = "Internal Server Error") : HTTPResult(500, error)
    class ResultUnknown(code: Int = -1, error: String = "HTTP Version Not Supported") :
        HTTPResult(code, error)
}

class Result422(error: String = "Data validation failed") : RuntimeException(error)

fun <T> Response<T>.responseCheck(
    bodyCheck: ((code: HTTPResult, body: String) -> Unit)? = null,
): Response<T> {
    val codeResult = code().toHTTPResult()
    val body = this.getStringBody()
    return bodyCheck?.invoke(codeResult, body).let { null } ?: run {
        when (codeResult) {
            is HTTPResult.Result200 -> this
            is HTTPResult.Result400 -> throw HTTPResult.Result400()
            is HTTPResult.Result401 -> throw HTTPResult.Result401()
            is HTTPResult.Result404 -> throw HTTPResult.Result404()
            is HTTPResult.Result500 -> throw HTTPResult.Result500()
            is HTTPResult.Result403 -> throw body.parseApiError()?.let { HTTPResult.Result403(it) }
                ?: HTTPResult.Result403()
            is HTTPResult.ResultUnknown -> throw body.parseApiError()
                ?.let { HTTPResult.ResultUnknown(code(), it) }
                ?: HTTPResult.ResultUnknown(code())
        }
    }
}

fun Int.toHTTPResult(): HTTPResult {
    return HTTPResult::class.sealedSubclasses
        .firstOrNull { it.objectInstance?.code == this }
        ?.objectInstance
        ?: HTTPResult.ResultUnknown()
}


val ResponseResult<*>?.size
    get() = if (this != null
        && this is ResponseResult.Success
        && data != null
        && data is List<*>
    ) {
        data.size
    } else if (this != null
        && this is ResponseResult.Success
        && data != null
    ) {
        1
    } else {
        0
    }

val ResponseResult<*>?.isEmpty get() = this.size == 0

val ResponseResult<*>?.isSucceeded get() = this != null && this is ResponseResult.Success && data != null

val ResponseResult<*>?.isError get() = this != null && this is ResponseResult.Error

inline infix fun <T, Value : Any> ResponseResult<T>.pagingSucceeded(
    predicate: (data: T) -> PagingSource.LoadResult<Int, Value>,
): PagingSource.LoadResult<Int, Value> {
    return if (this is ResponseResult.Success && this.data != null) {
        predicate.invoke(this.data)
    } else {
        if (this is ResponseResult.Error) {
            PagingSource.LoadResult.Error(this.exception)
        } else {
            PagingSource.LoadResult.Error(RuntimeException("Error response"))
        }
    }
}

inline infix fun <T> ResponseResult<T>.success(predicate: (data: T) -> Unit): ResponseResult<T> {
    if (this is ResponseResult.Success && this.data != null) {
        predicate.invoke(this.data)
    }
    return this
}

inline infix fun <T> ResponseResult<T>.error(predicate: (data: Exception) -> Unit): ResponseResult<T> {
    if (this is ResponseResult.Error) {
        if (this.exception !is UnknownHostException) {
            predicate.invoke(this.exception)
        }
    }
    return this
}

inline infix fun <T> ResponseResult<T>.errorUnknownHost(predicate: (data: Exception) -> Unit): ResponseResult<T> {
    if (this is ResponseResult.Error) {
        if (this.exception is UnknownHostException) {
            predicate.invoke(this.exception)
        }
    }
    return this
}

inline infix fun <T> ResponseResult<T>.done(predicate: () -> Unit): ResponseResult<T> {
    predicate.invoke()
    return this
}