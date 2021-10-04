package com.asprog.imct.modules.home.services.apiService

import com.asprog.imct.modules.home.services.api.ApiHome
import com.asprog.imct.modules.home.services.apiService.impl.*
import javax.inject.Inject

class ApiServiceHome @Inject constructor(
    override val api: ApiHome,
) : ApiServiceDelete, ApiServiceGet, ApiServicePatch, ApiServicePost, ApiServicePut