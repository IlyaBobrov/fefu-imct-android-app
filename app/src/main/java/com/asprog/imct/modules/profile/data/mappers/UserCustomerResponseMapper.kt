package com.asprog.imct.modules.profile.data.mappers

import com.asprog.imct.modules._common.data.UserModel
import com.asprog.imct.modules.profile.data.responses.UserCustomerResponse


fun UserCustomerResponse.toModel(): UserModel {
    return UserModel(
        id = customer.uid,
        name = customer.name,
        email = customer.email,
    )
}