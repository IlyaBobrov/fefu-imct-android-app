package com.asprog.imct.modules.home.data.mock

import com.asprog.imct.modules.home.data.models.HomeModel
import com.asprog.imct.modules.home.data.relations.HomeRelation

fun mockHomeModel() = HomeRelation(
    owner = HomeModel(
        id = "id",
//        newsName = "",
    ),
    banners = listOf(),
    ads = listOf(),
    news = listOf(),
)