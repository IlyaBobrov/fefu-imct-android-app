package com.asprog.imct.modules.profile.services.data.impl

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules._common.data.DaoUserModel
import com.asprog.imct.modules._common.data.UserModel
import kotlinx.coroutines.flow.Flow

interface DataUserModel {
    val db: AppDatabase
    val preferences: AppPreferences

    private val dao: DaoUserModel get() = db.daoUserModel()

    suspend fun updateUser(model: UserModel) {
        dao.clear()
        dao.insertModels(*listOf(model).toTypedArray())
    }

    fun getUser(): Flow<UserModel?> {
        return dao.getModel()
    }

    suspend fun isEmpty(): Boolean {
        return dao.count() == 0
    }
}