package com.asprog.imct.modules.profile.data.mappers

import com.asprog.imct.modules.profile.data.models.UserContactEmailModel
import com.asprog.imct.modules.profile.data.models.UserContactPhoneModel
import com.asprog.imct.modules.profile.data.models.UserContactsModel
import com.asprog.imct.modules.profile.data.responses.UserContactsResponse
import java.util.*

fun UserContactsResponse.toModel(): UserContactsModel {
    return UserContactsModel(
        id = UUID.randomUUID().toString(),
        email = email.let {
            UserContactEmailModel(
                confirmedContactEmail = it.confirmed ?: false,
                contactEmail = it.email ?: "",
                notifyMailShort = it.notifyMailShort ?: false,
                notifyMailFull = it.notifyMailFull ?: false,
            )
        },
        phone = phone.let {
            UserContactPhoneModel(
                confirmedContactPhone = it.confirmed ?: false,
                contactPhone = it.phone ?: "",
                notifySmsShort = it.notifySmsShort ?: false,
                notifySmsFull = it.notifySmsFull ?: false,
            )
        },
    )
}