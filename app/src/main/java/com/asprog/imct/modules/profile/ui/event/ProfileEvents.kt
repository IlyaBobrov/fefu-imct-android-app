package com.asprog.imct.modules.profile.ui.event

sealed class ProfileEvents {
    object NavigateBack : ProfileEvents()
    object UpdateUser : ProfileEvents()
    object NavigateToSignIn : ProfileEvents()
    object NavigateLogout : ProfileEvents()
}