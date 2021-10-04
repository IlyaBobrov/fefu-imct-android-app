package com.asprog.imct.modules.home.data.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.asprog.imct.base.interfaces.IModel
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class HomeModel(
    @PrimaryKey override val id: String,
//    val newsName: String,
    @Ignore private val banners: List<HomeBannerModel>,
    @Ignore private val ads: List<HomeAdsModel>,
    @Ignore private val news: List<HomeNewsModel>,
) : IModel {

    constructor(id: String/*, newsName: String*/) : this(
        id,/* newsName,*/
        listOf(),
        listOf(),
        listOf()
    )

    companion object {
        fun List<HomeModel>.getBannersArray(): Array<HomeBannerModel> {
            return this
                .map { it.banners.toList() }
                .reduce { acc, tags -> acc + tags }
                .toTypedArray()
        }

        fun List<HomeModel>.getAdsArray(): Array<HomeAdsModel> {
            return this
                .map { it.ads.toList() }
                .reduce { acc, tags -> acc + tags }
                .toTypedArray()
        }

        fun List<HomeModel>.getNewsArray(): Array<HomeNewsModel> {
            return this
                .map { it.news.toList() }
                .reduce { acc, tags -> acc + tags }
                .toTypedArray()
        }

    }
}