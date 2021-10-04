package com.asprog.imct.modules.profile.data.request

data class UserContactRequest(
    val email: UserContactEmailRequest,
    val phone: UserContactPhoneRequest,
)

data class UserContactEmailRequest(
    val confirmed: Boolean,
    val email: String,
    val notifyMailFull: Boolean,
    val notifyMailShort: Boolean,
)

data class UserContactPhoneRequest(
    val confirmed: Boolean,
    val phone: String,
    val notifySmsFull: Boolean,
    val notifySmsShort: Boolean,
)