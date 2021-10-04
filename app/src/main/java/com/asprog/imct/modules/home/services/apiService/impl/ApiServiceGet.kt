package com.asprog.imct.modules.home.services.apiService.impl

import com.asprog.imct.BuildConfig
import com.asprog.imct.base.LocalTryExecuteWithResponse.executeWithResponse
import com.asprog.imct.base.ResponseResult
import com.asprog.imct.base.responseCheck
import com.asprog.imct.modules.home.data.mappers.toModel
import com.asprog.imct.modules.home.data.models.HomeModel
import com.asprog.imct.modules.home.services.api.ApiHome
import com.asprog.imct.urils.ConstantsApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

interface ApiServiceGet {

    val api: ApiHome

    suspend fun getHome(): ResponseResult<HomeModel?> {
        return withContext(Dispatchers.IO) {
            if (BuildConfig.DEBUG) delay(ConstantsApp.DEBUG_DELAY) // Simulate slow internet
            executeWithResponse {
                api.getHome()
                    .responseCheck()
                    .body()
                    ?.toModel()
            }
        }
    }
}