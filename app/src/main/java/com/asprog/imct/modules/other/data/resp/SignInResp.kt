package com.asprog.imct.modules.other.data.resp

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.android.parcel.Parcelize

@Immutable
data class SignInResp(
    val status: String,
    val access_token: String? = null,
    val user: UserRespImmutable? = null,
    val errors: MyError? = null
)

@Immutable
data class MyError(
    val code: Int? = null,
)

@Immutable
data class UserRespImmutable(
    val id: Int,
    val name: String,
    val email: String,
    val role: Int
)

@Parcelize
data class UserResp(
    val id: Int,
    val name: String,
    val email: String,
    val role: Int
): Parcelable