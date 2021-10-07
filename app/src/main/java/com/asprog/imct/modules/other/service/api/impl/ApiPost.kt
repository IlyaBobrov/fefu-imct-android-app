package com.asprog.imct.modules.other.service.api.impl

import com.asprog.imct.modules.other.data.req.SignInReq
import com.asprog.imct.modules.other.data.resp.SignInResp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiPost {
    @POST("auth.login")
    suspend fun signIn(@Body request: SignInReq): Response<SignInResp>
}