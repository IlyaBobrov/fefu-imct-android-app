package com.asprog.imct.modules.profile.services.apiService.impl

import com.asprog.imct.BuildConfig
import com.asprog.imct.base.LocalTryExecuteWithResponse.executeWithResponse
import com.asprog.imct.base.ResponseResult
import com.asprog.imct.base.responseCheck
import com.asprog.imct.modules._common.data.UserModel
import com.asprog.imct.modules.profile.data.mappers.toModel
import com.asprog.imct.modules.profile.data.models.UserContactsModel
import com.asprog.imct.modules.profile.services.api.ApiProfile
import com.asprog.imct.urils.ConstantsApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

interface ApiServiceGet {

    val api: ApiProfile

    suspend fun getUser(): ResponseResult<UserModel> {
        return withContext(Dispatchers.IO) {
            if (BuildConfig.DEBUG) delay(ConstantsApp.DEBUG_DELAY) // Simulate slow internet
            executeWithResponse {
                api.getUser()
                    .responseCheck()
                    .body()
                    ?.toModel()!!
            }
        }
    }

    suspend fun getUserContacts(): ResponseResult<UserContactsModel> {
        return withContext(Dispatchers.IO) {
            if (BuildConfig.DEBUG) delay(ConstantsApp.DEBUG_DELAY) // Simulate slow internet
            executeWithResponse {
                api.getUserContacts()
                    .responseCheck()
                    .body()
                    ?.toModel()!!
            }
        }
    }
}