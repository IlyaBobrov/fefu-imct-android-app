package com.asprog.imct.modules.info.services

import javax.inject.Inject

class InfoRemoteData @Inject constructor(
    private val infoService: InfoService
) {

    suspend fun getInfoScreen() = infoService.getInfoScreen()

}