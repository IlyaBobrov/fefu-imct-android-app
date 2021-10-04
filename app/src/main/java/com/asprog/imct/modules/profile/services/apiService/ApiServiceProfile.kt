package com.asprog.imct.modules.profile.services.apiService

import com.asprog.imct.modules.profile.services.apiService.impl.*
import com.asprog.imct.modules.profile.services.api.ApiProfile
import javax.inject.Inject

class ApiServiceProfile @Inject constructor(
    override val api: ApiProfile,
) : ApiServiceDelete, ApiServiceGet, ApiServicePatch, ApiServicePost, ApiServicePut