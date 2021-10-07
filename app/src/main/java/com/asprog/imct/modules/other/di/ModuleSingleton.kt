package com.asprog.imct.modules.other.di

import com.asprog.imct.modules.other.service.api.ApiOther
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ModuleSingleton {

    @Provides
    fun provideApiOther(retrofit: Retrofit) = retrofit.create(ApiOther::class.java)
}