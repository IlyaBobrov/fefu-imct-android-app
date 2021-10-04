package com.asprog.imct.modules.profile.services.api.impl


import com.asprog.imct.modules.profile.data.responses.UserContactsResponse
import com.asprog.imct.modules.profile.data.responses.UserCustomerResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiGet {
    @GET("customers/current/profile")
    suspend fun getUser(): Response<UserCustomerResponse>

    @GET("customers/current/contacts")
    suspend fun getUserContacts(): Response<UserContactsResponse>
}



