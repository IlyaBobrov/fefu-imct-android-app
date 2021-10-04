package com.asprog.imct.modules.home.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asprog.imct.modules.home.data.models.HomeNewsModel


@Dao
interface DaoHomeNewsModel {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: HomeNewsModel)

    @Query("DELETE FROM HomeNewsModel")
    suspend fun clear()
}