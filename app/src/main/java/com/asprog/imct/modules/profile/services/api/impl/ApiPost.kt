package com.asprog.imct.modules.profile.services.api.impl

import com.asprog.imct.modules.profile.data.request.UserContactRequest
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiPost {

    @POST("customers/current/contacts")
    suspend fun updateUserContacts(@Body request: UserContactRequest): Response<Any>

    @POST("customers/current/contacts/check-code")
    suspend fun checkCode(
        @Query("configGroupCode") configGroupCode: String,
        @Query("contact") contact: String,
        @Query("code") code: String,
    ): Response<JsonObject>

    @POST("customers/current/contacts/send-code")
    suspend fun sendCode(
        @Query("configGroupCode") configGroupCode: String,
        @Query("contact") contact: String,
    ): Response<JsonObject>
}