package com.asprog.imct.urils

import com.asprog.imct.BuildConfig

object ConstantsApp {

    const val REFRESH_DELAY = 60000L

    const val DEBUG_DELAY = 1000L

    val API_URL_BASE
        get() =
            if (BuildConfig.DEBUG)
                "http://188.93.210.175:5001/api"
            else
                "http://188.93.210.175:5001/api/"

    // TODO: 29.09.2021 URL and debug login

    val API_URL get() = "$API_URL_BASE/"


    val DEBUG_CREDENTIAL_LOGIN get() = if (BuildConfig.DEBUG) "vasya3@gmail.com" else ""
    val DEBUG_CREDENTIAL_PASSW get() = if (BuildConfig.DEBUG) "" else ""
}