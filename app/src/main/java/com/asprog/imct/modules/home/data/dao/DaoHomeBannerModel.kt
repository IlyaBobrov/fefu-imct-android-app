package com.asprog.imct.modules.home.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asprog.imct.modules.home.data.models.HomeBannerModel


@Dao
interface DaoHomeBannerModel {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: HomeBannerModel)

    @Query("DELETE FROM HomeBannerModel")
    suspend fun clear()
}