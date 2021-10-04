package com.asprog.imct.modules.home.services.data.impl

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules.home.data.dao.DaoHomeAdsModel
import com.asprog.imct.modules.home.data.dao.DaoHomeBannerModel
import com.asprog.imct.modules.home.data.dao.DaoHomeModel
import com.asprog.imct.modules.home.data.dao.DaoHomeNewsModel
import com.asprog.imct.modules.home.data.models.HomeModel
import com.asprog.imct.modules.home.data.models.HomeModel.Companion.getAdsArray
import com.asprog.imct.modules.home.data.models.HomeModel.Companion.getBannersArray
import com.asprog.imct.modules.home.data.models.HomeModel.Companion.getNewsArray
import com.asprog.imct.modules.home.data.relations.HomeRelation
import kotlinx.coroutines.flow.Flow


interface DataHomeModel {

    val db: AppDatabase
    val preferences: AppPreferences

    private val dao: DaoHomeModel get() = db.daoHome()
    private val daoBanner: DaoHomeBannerModel get() = db.daoHomeBannerModel()
    private val daoAds: DaoHomeAdsModel get() = db.daoHomeAdsModel()
    private val daoNews: DaoHomeNewsModel get() = db.daoHomeNewsModel()

    suspend fun insert(vararg models: HomeModel) {
        models.toList().let {
            // save banners
            daoBanner.insertModels(*it.getBannersArray())
            // save ads
            daoAds.insertModels(*it.getAdsArray())
            // save news
            daoNews.insertModels(*it.getNewsArray())
            // save model
            dao.insertModels(*models)
        }
    }

    suspend fun clear() {
        daoBanner.clear()
        daoAds.clear()
        daoNews.clear()
        dao.clear()
    }

    fun getHomeRelation(): Flow<HomeRelation?> {
        return dao.getHomeRelation()
    }

    suspend fun count(): Int {
        return dao.count()
    }
}