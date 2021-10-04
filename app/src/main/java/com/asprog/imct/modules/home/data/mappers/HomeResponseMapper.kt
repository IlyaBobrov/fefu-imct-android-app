package com.asprog.imct.modules.home.data.mappers

import com.asprog.imct.modules.home.data.models.HomeAdsModel
import com.asprog.imct.modules.home.data.models.HomeBannerModel
import com.asprog.imct.modules.home.data.models.HomeModel
import com.asprog.imct.modules.home.data.models.HomeNewsModel
import com.asprog.imct.modules.home.data.responses.HomeResponse
import java.util.*

fun HomeResponse.toModel(): HomeModel {
    val rootId = UUID.randomUUID().toString()
    return HomeModel(
        id = rootId,
//        newsName = news?.get(0)?.title ?: "",
        banners = banners?.map { banner ->
            HomeBannerModel(
                id = banner.id ?: UUID.randomUUID().toString(),
                ownerId = rootId,
                image = banner.image ?: "",
                url = banner.url ?: "",
            )
        } ?: listOf(),
        ads = ads?.map { ad ->
            HomeAdsModel(
                id = ad.id ?: UUID.randomUUID().toString(),
                ownerId = rootId,
                title = ad.title ?: "",
                description = ad.description ?: "",
                time = ad.time ?: "",
            )
        } ?: listOf(),
        news = news?.map { news ->
            HomeNewsModel(
                id = news.id ?: UUID.randomUUID().toString(),
                ownerId = rootId,
                title = news.title ?: "",
                description = news.description ?: "",
                creator = news.creator ?: "",
                images = news.images ?: ""//news.images ?: listOf()
            )
        } ?: listOf(),
    )
}