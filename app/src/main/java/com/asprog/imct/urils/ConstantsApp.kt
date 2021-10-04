package com.asprog.imct.urils

import com.asprog.imct.BuildConfig

object ConstantsApp {

    const val REFRESH_DELAY = 60000L

    const val DEBUG_DELAY = 1000L

    val API_URL_BASE
        get() =
            if (BuildConfig.DEBUG)
                "https://rsttur.ru/api/base-app"
            else
                ""

    // TODO: 29.09.2021 URL and debug login

    val API_URL get() = "$API_URL_BASE/"


    val DEBUG_CREDENTIAL_LOGIN get() = if (BuildConfig.DEBUG) "bobrovii@dvfu.students.ru" else ""
    val DEBUG_CREDENTIAL_PASSW get() = if (BuildConfig.DEBUG) "" else ""
}