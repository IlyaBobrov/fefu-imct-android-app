package com.asprog.imct.modules.profile.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.asprog.imct.base.interfaces.IModel

@Entity
@Immutable
data class UserContactsModel(
    @PrimaryKey override val id: String,
    @Embedded val email: UserContactEmailModel,
    @Embedded val phone: UserContactPhoneModel,
) : IModel

@Immutable
data class UserContactEmailModel(
    val confirmedContactEmail: Boolean,
    val contactEmail: String,
    val notifyMailShort: Boolean,
    val notifyMailFull: Boolean,
)

@Immutable
data class UserContactPhoneModel(
    val confirmedContactPhone: Boolean,
    val contactPhone: String,
    val notifySmsShort: Boolean,
    val notifySmsFull: Boolean,
)
