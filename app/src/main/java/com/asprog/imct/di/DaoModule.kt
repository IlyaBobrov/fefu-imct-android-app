package com.asprog.imct.di

import com.asprog.imct.base.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    // TODO: 29.09.2021 для настроек
    /*@Provides
    fun provideDaoProducts(appDatabase: AppDatabase) = appDatabase.daoFavorite()*/
}