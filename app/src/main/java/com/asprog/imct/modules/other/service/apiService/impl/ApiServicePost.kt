package com.asprog.imct.modules.other.service.apiService.impl

import com.asprog.imct.base.LocalTryExecuteWithResponse.executeWithResponse
import com.asprog.imct.base.ResponseResult
import com.asprog.imct.base.responseCheck
import com.asprog.imct.modules.other.data.req.SignInReq
import com.asprog.imct.modules.other.data.resp.SignInResp
import com.asprog.imct.modules.other.service.api.ApiOther
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface ApiServicePost {

    val api: ApiOther

    suspend fun signIn(login: String, passw: String): ResponseResult<SignInResp> {
        return withContext(Dispatchers.IO) {
            executeWithResponse {
                api.signIn(
                    SignInReq(
                        email = login,
                        password = passw,
                    )
                )
                    .responseCheck()
                    .body()!!
            }
        }
    }
}