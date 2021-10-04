package com.asprog.imct.modules.info.services

import com.asprog.imct.modules.info.data.responses.InfoResponse
import retrofit2.Response
import retrofit2.http.GET

interface InfoService {

    @GET("")
    suspend fun getInfoScreen(): Response<InfoResponse>


}