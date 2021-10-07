package com.asprog.imct.modules.other.service.apiService

import com.asprog.imct.modules.other.service.api.ApiOther
import com.asprog.imct.modules.other.service.apiService.impl.*

import javax.inject.Inject

class ApiServiceOther @Inject constructor(
    override val api: ApiOther,
) : ApiServiceDelete, ApiServiceGet, ApiServicePatch, ApiServicePost, ApiServicePut