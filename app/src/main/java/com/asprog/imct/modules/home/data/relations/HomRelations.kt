package com.asprog.imct.modules.home.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.asprog.imct.modules.home.data.models.HomeAdsModel
import com.asprog.imct.modules.home.data.models.HomeBannerModel
import com.asprog.imct.modules.home.data.models.HomeModel
import com.asprog.imct.modules.home.data.models.HomeNewsModel

data class HomeRelation(
    @Embedded
    val owner: HomeModel,
    @Relation(parentColumn = "id", entityColumn = "ownerId")
    val banners: List<HomeBannerModel>,
    @Relation(parentColumn = "id", entityColumn = "ownerId")
    val ads: List<HomeAdsModel>,
    @Relation(parentColumn = "id", entityColumn = "ownerId")
    val news: List<HomeNewsModel>,
)