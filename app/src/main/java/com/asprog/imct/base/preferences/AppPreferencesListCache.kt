package com.asprog.imct.base.preferences

import android.content.SharedPreferences

interface AppPreferencesListCache {

    val p: SharedPreferences

    enum class KEYS {
        LAST_UPDATE_HOME,
        LAST_UPDATE_INFO_SCREEN,
        LAST_UPDATE_NEWS_POSTS,
        LAST_UPDATE_NEWS_ADS,
        LAST_UPDATE_LIST_OPTIONS,
    }

    fun clearAfterLogout() {
        lastUpdateListNewsAds = 0L
        lastUpdateNewsPosts = 0L
        lastUpdateHome = 0L
    }

    var lastUpdateHome: Long
        get() = p.getLong(KEYS.LAST_UPDATE_HOME.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_HOME.name, value).apply()

    var lastUpdateInfoScreen: Long
        get() = p.getLong(KEYS.LAST_UPDATE_INFO_SCREEN.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_INFO_SCREEN.name, value).apply()

    var lastUpdateNewsPosts: Long
        get() = p.getLong(KEYS.LAST_UPDATE_NEWS_POSTS.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_NEWS_POSTS.name, value).apply()

    var lastUpdateListNewsAds: Long
        get() = p.getLong(KEYS.LAST_UPDATE_NEWS_ADS.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_NEWS_ADS.name, value).apply()

    var lastUpdateListOptions: Long
        get() = p.getLong(KEYS.LAST_UPDATE_LIST_OPTIONS.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_LIST_OPTIONS.name, value).apply()

}