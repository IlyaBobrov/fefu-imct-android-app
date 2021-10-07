package com.asprog.imct.base.preferences

import android.content.SharedPreferences
import android.util.Log
import com.asprog.imct.modules.other.data.resp.UserResp

interface AppPreferencesBase {

    val p: SharedPreferences

    enum class KEYS {
        ACCESS_TOKEN,
        REFRESH_TOKEN,
        IS_START_PAGE,
        USER_ID,
        USER_NAME,
        USER_EMAIL,
        USER_ROLE
    }

    fun isLogin(): Boolean {
        return _accessToken.isNotEmpty()
    }

    fun getUser(): UserResp {

        Log.e("TAG", "getUser:_ $_userId ", )
        Log.e("TAG", "getUser:_ $_userName", )
        Log.e("TAG", "getUser:_ $_userEmail", )
        Log.e("TAG", "getUser:_ $_userRole", )
        return UserResp(
            if (_userId == "") -1 else _userId.toInt(),
            _userName,
            _userEmail,
            if (_userRole == "") -1 else _userRole.toInt()
        )
    }

    fun clearAfterLogout() {
        Log.e("TAG", "clearAfterLogout: ", )
        _accessToken = ""
        _refreshToken = ""
        _userId = ""
        _userName = ""
        _userEmail = ""
        _userRole = ""
    }

    val accessToken: String get() = _accessToken
    private var _accessToken: String
        get() = p.getString(KEYS.ACCESS_TOKEN.name, null) ?: ""
        set(value) = p.edit().putString(KEYS.ACCESS_TOKEN.name, value).apply()


    val refreshToken: String get() = _refreshToken
    private var _refreshToken: String
        get() = p.getString(KEYS.REFRESH_TOKEN.name, null) ?: ""
        set(value) = p.edit().putString(KEYS.REFRESH_TOKEN.name, value).apply()

    val userId: String get() = _userId
    private var _userId: String
        get() = p.getString(KEYS.USER_ID.name, null) ?: ""
        set(value) = p.edit().putString(KEYS.USER_ID.name, value).apply()

    val userName: String get() = _userName
    private var _userName: String
        get() = p.getString(KEYS.USER_NAME.name, null) ?: ""
        set(value) = p.edit().putString(KEYS.USER_NAME.name, value).apply()

    val userEmail: String get() = _userEmail
    private var _userEmail: String
        get() = p.getString(KEYS.USER_EMAIL.name, null) ?: ""
        set(value) = p.edit().putString(KEYS.USER_EMAIL.name, value).apply()

    val userRole: String get() = _userRole
    private var _userRole: String
        get() = p.getString(KEYS.USER_ROLE.name, null) ?: ""
        set(value) = p.edit().putString(KEYS.USER_ROLE.name, value).apply()

    fun setTokens(accessTokenCode: String, refreshToken: String) {
        _accessToken = accessTokenCode
        _refreshToken = refreshToken
    }

    fun setUser(user: UserResp/*? = null*/) {
        if (user == null) {
            Log.e("TAG", "setUser: USER IS NULL", )
            _userId = ""
            _userName = ""
            _userEmail = ""
            _userRole = ""
        } else {
            Log.e("TAG", "setUser: USER IS NOT NULL!!!", )
            Log.e("TAG", "setUser: USER: $user" )
            _userId = user.id.toString()
            _userName = user.name
            _userEmail = user.email
            _userRole = user.role.toString()

        }
    }

    // TODO: 29.09.2021 start page
    var isStartPage: Boolean
        get() = p.getBoolean(KEYS.IS_START_PAGE.name, true)
        set(value) = p.edit().putBoolean(KEYS.IS_START_PAGE.name, value).apply()
}