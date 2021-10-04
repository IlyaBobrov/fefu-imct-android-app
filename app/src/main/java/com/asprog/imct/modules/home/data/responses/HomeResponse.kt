package com.asprog.imct.modules.home.data.responses

import androidx.compose.runtime.Immutable

@Immutable
data class HomeResponse(
    val banners: List<BannerResponse>?,
    val ads: List<AdsResponse>?,
    val news: List<NewsResponse>?
)

@Immutable
data class BannerResponse(
    val id: String?,
    val image: String?,
    val url: String?,
)

@Immutable
data class AdsResponse(
    val id: String?,
    val title: String?,
    val description: String?,
    val time: String?
)

@Immutable
data class NewsResponse(
    val id: String?,
    val title: String?,
    val description: String?,
    val images: String?,  //не получилось : List<String>?,
    val creator: String?
)

//****



