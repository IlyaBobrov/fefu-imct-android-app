package com.asprog.imct.modules._common.service

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.BaseDataService
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules._common.data.DaoUserModel
import com.asprog.imct.modules.profile.data.dao.DaoUserContactsModel

class DataServiceCommon(
    override val db: AppDatabase,
    override val preferences: AppPreferences,
) : BaseDataService<DataServiceCommon> {

//    private val daoFavorite: DaoFavoriteModel get() = db.daoFavorite()
    private val daoUser: DaoUserModel get() = db.daoUserModel()
    private val daoUserContacts: DaoUserContactsModel get() = db.daoUserContactsModel()



    suspend fun clearAfterLogout() {
        daoUserContacts.clear()
//        daoFavorite.clear()
        daoUser.clear()
    }
}