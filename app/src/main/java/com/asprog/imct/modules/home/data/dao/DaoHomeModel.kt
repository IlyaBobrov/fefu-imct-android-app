package com.asprog.imct.modules.home.data.dao

import androidx.room.*
import com.asprog.imct.modules._common.data.ImageListConverter
import com.asprog.imct.modules.home.data.models.HomeModel
import com.asprog.imct.modules.home.data.relations.HomeRelation
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoHomeModel {

    @Transaction
    @Query("SELECT * FROM HomeModel")
    fun getHomeRelation(): Flow<HomeRelation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: HomeModel)

    @Query("DELETE FROM HomeModel")
    suspend fun clear()

    @Query("SELECT COUNT(*) FROM HomeModel")
    suspend fun count(): Int

}