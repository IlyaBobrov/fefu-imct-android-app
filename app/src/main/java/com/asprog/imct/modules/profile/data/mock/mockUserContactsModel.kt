package com.asprog.imct.modules.profile.data.mock

import com.asprog.imct.modules.profile.data.models.UserContactEmailModel
import com.asprog.imct.modules.profile.data.models.UserContactPhoneModel
import com.asprog.imct.modules.profile.data.models.UserContactsModel

fun mockUserContactsModel(): UserContactsModel {
    return UserContactsModel(
        id = "id",
        email = UserContactEmailModel(
            confirmedContactEmail = true,
            contactEmail = "email@gmail.com",
            notifyMailShort = true,
            notifyMailFull = true,
        ),
        phone = UserContactPhoneModel(
            confirmedContactPhone = true,
            contactPhone = "+ 7 123 121 12",
            notifySmsShort = true,
            notifySmsFull = true,
        ),
    )
}