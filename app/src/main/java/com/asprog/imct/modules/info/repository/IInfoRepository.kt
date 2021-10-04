package com.asprog.imct.modules.info.repository

import com.asprog.imct.modules._common.service.ServerResult
import com.asprog.imct.modules.info.data.responses.InfoResponse

interface IInfoRepository {

    suspend fun getInfo(): ServerResult<InfoResponse>
}