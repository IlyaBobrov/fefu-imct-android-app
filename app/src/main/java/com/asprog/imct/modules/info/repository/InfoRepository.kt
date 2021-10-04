package com.asprog.imct.modules.info.repository

import com.asprog.imct.modules._common.service.ServerResult
import com.asprog.imct.modules.info.data.mock.MockInfoResponse
import com.asprog.imct.modules.info.data.responses.InfoResponse
import com.asprog.imct.modules.info.services.InfoRemoteData
import com.asprog.imct.urils.DebugLocalData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InfoRepository @Inject constructor(
    private val remoteData: InfoRemoteData
) : IInfoRepository {

    override suspend fun getInfo(): ServerResult<InfoResponse> {
        return withContext(Dispatchers.IO) {
            val result = if (DebugLocalData) {
                delay(2000)
                Response.success(MockInfoResponse)
            } else {
                remoteData.getInfoScreen()
            }
            if (result.isSuccessful && result.body() != null) {
                ServerResult.Success(result.body()!!)
            } else {
                ServerResult.Error(IllegalArgumentException("Unable to find post(example)"))
            }
        }
    }

}