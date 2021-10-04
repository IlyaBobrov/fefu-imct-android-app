package com.asprog.imct.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asprog.imct.modules._common.data.DaoUserModel
import com.asprog.imct.modules._common.data.UserModel
import com.asprog.imct.modules.home.data.dao.DaoHomeAdsModel
import com.asprog.imct.modules.home.data.dao.DaoHomeBannerModel
import com.asprog.imct.modules.home.data.dao.DaoHomeModel
import com.asprog.imct.modules.home.data.dao.DaoHomeNewsModel
import com.asprog.imct.modules.home.data.models.HomeAdsModel
import com.asprog.imct.modules.home.data.models.HomeBannerModel
import com.asprog.imct.modules.home.data.models.HomeModel
import com.asprog.imct.modules.home.data.models.HomeNewsModel
import com.asprog.imct.modules.profile.data.dao.DaoUserContactsModel
import com.asprog.imct.modules.profile.data.models.UserContactsModel


@Database(
    entities = [
        HomeModel::class,
        HomeBannerModel::class,
        HomeAdsModel::class,
        HomeNewsModel::class,
//        BrandModel::class,
//        CategoryModel::class,
//        SubCategoryModel::class,
        UserModel::class,
        UserContactsModel::class,
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoHome(): DaoHomeModel
    abstract fun daoHomeBannerModel(): DaoHomeBannerModel
    abstract fun daoHomeAdsModel(): DaoHomeAdsModel
    abstract fun daoHomeNewsModel(): DaoHomeNewsModel

    //    abstract fun daoBrandModel(): DaoBrandModel
//    abstract fun daoCategoryModel(): DaoCategoryModel
//    abstract fun daoSubCategoryModel(): DaoSubCategoryModel
    abstract fun daoUserModel(): DaoUserModel
    abstract fun daoUserContactsModel(): DaoUserContactsModel
}