package com.asprog.imct.modules.profile.data.responses

import androidx.compose.runtime.Immutable

@Immutable
data class UserContactsResponse(
    val email: UserContactsEmailResponse,
    val phone: UserContactsPhoneResponse,
)

@Immutable
data class UserContactsEmailResponse(
    val confirmed: Boolean?,
    val email: String?,
    val notifyMailShort: Boolean?,
    val notifyMailFull: Boolean?,
)

@Immutable
data class UserContactsPhoneResponse(
    val confirmed: Boolean?,
    val phone: String?,
    val notifySmsShort: Boolean?,
    val notifySmsFull: Boolean?,
)