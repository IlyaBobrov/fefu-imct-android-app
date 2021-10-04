package com.asprog.imct.modules.profile.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asprog.imct.modules.profile.data.models.UserContactsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoUserContactsModel {

    @Query("SELECT * FROM UserContactsModel LIMIT 1")
    suspend fun getModel(): UserContactsModel?

    @Query("SELECT * FROM UserContactsModel LIMIT 1")
    fun getModelFlow(): Flow<UserContactsModel?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: UserContactsModel)

    @Query("DELETE FROM UserContactsModel")
    suspend fun clear()

    @Query("SELECT COUNT(*) FROM UserContactsModel")
    suspend fun count(): Int
}