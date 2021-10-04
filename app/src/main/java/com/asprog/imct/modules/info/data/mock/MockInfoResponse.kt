package com.asprog.imct.modules.info.data.mock

import com.asprog.imct.modules.info.data.responses.DirectionsResponse
import com.asprog.imct.modules.info.data.responses.InfoResponse

val MockInfoResponse = InfoResponse(
    department = null,
    teachers = null,
    directions = listOf(
     DirectionsResponse("hello"),
     DirectionsResponse("world"),
     DirectionsResponse("!!!")
    )
)