package com.asprog.imct.modules.info.di

import com.asprog.imct.modules.info.services.InfoRemoteData
import com.asprog.imct.modules.info.services.InfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object InfoApiModule {

    @Provides
    @Singleton
    fun provideInfoService(retrofit: Retrofit): InfoService =
        retrofit.create(InfoService::class.java)

    @Provides
    @Singleton
    fun provideInfoRemoteData(mainService: InfoService): InfoRemoteData =
        InfoRemoteData(mainService)
}