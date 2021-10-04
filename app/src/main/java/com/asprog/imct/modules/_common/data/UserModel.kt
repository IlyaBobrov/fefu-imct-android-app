package com.asprog.imct.modules._common.data

import androidx.compose.runtime.Immutable
import androidx.room.*
import com.asprog.imct.base.interfaces.IModel
import kotlinx.coroutines.flow.Flow

@Entity
@Immutable
data class UserModel(
    @PrimaryKey override val id: String,
    val name: String,
    val email: String,
) : IModel

@Dao
interface DaoUserModel {
    @Query("SELECT * FROM UserModel LIMIT 1")
    fun getModel(): Flow<UserModel?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: UserModel)

    @Query("DELETE FROM UserModel")
    suspend fun clear()

    @Query("SELECT COUNT(*) FROM UserModel")
    suspend fun count(): Int
}