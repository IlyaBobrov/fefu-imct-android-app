package com.asprog.imct.modules.other.ui.events

sealed class SignInEvents {
    object NavigateBack : SignInEvents()
    data class SignIn(val login: String, val passw: String) : SignInEvents()
}