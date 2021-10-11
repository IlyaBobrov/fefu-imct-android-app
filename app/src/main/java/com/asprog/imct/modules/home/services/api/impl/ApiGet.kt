package com.asprog.imct.modules.home.services.api.impl

import com.asprog.imct.modules.home.data.responses.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiGet {
    @GET("news.get")
    suspend fun getHome(): Response<HomeResponse>
}