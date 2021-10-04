package com.asprog.imct.modules.home.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asprog.imct.modules.home.data.models.HomeAdsModel


@Dao
interface DaoHomeAdsModel {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: HomeAdsModel)

    @Query("DELETE FROM HomeAdsModel")
    suspend fun clear()
}