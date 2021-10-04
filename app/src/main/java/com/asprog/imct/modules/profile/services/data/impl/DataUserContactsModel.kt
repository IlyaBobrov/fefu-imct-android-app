package com.asprog.imct.modules.profile.services.data.impl

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules.profile.data.dao.DaoUserContactsModel
import com.asprog.imct.modules.profile.data.models.UserContactsModel
import kotlinx.coroutines.flow.Flow

interface DataUserContactsModel {
    val db: AppDatabase
    val preferences: AppPreferences

    private val dao: DaoUserContactsModel get() = db.daoUserContactsModel()

    suspend fun updateUserContacts(model: UserContactsModel) {
        dao.clear()
        dao.insertModels(*listOf(model).toTypedArray())
    }

    suspend fun getUserContacts(): UserContactsModel? {
        return dao.getModel()
    }

    fun getUserContactsFlow(): Flow<UserContactsModel?> {
        return dao.getModelFlow()
    }
}