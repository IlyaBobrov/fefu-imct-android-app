package com.asprog.imct.modules.info.data.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoResponse(
    @SerializedName("department")
    val department: DepartmentResponse? = null,
    @SerializedName("teachers")
    val teachers: List<TeachersResponse>? = null,
    @SerializedName("directions")
    val directions: List<DirectionsResponse>? = null
) : Parcelable

@Parcelize
data class DepartmentResponse(
    @SerializedName("textInfo")
    val textInfo: String? = null
) : Parcelable

@Parcelize
data class TeachersResponse(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
) : Parcelable

@Parcelize
data class DirectionsResponse(
    @SerializedName("text")
    val text: String? = null
) : Parcelable
