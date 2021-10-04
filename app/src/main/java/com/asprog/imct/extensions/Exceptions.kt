package com.asprog.imct.extensions

import timber.log.Timber

fun Exception?.logging(defaultMessage: String): String {
    return this?.let { ex ->
        Timber.e(ex)
        ex.message
    } ?: defaultMessage
}