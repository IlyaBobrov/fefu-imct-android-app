package com.asprog.imct.modules.info.data.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class InfoResponse(
    val department: DepartmentResponse? = null,
    val teachers: List<TeachersResponse>? = null,
    val directions: List<DirectionsResponse>? = null
)
data class DepartmentResponse(
    val textInfo: String
)
data class TeachersResponse(
    val name: String? = null,
    val imageUrl: String ? = null
)

data class DirectionsResponse(
    val title: String? = null,
    val direction: List<DirectionSec>
)
data class DirectionSec(
    val title:String,
    val desc: String
)