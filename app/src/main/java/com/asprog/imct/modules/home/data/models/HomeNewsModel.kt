package com.asprog.imct.modules.home.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.asprog.imct.base.interfaces.IModelRelation


@Entity
@Immutable
data class HomeNewsModel(
    @PrimaryKey
    override val id: String,
    override val ownerId: String,
    val title: String,
    val description: String,
    val images: String, //TOdo
    val creator: String,
) : IModelRelation