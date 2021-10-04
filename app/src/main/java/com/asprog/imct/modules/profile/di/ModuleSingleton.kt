package com.asprog.imct.modules.profile.di

import com.asprog.imct.modules.profile.services.api.ApiProfile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object ModuleSingleton {

    @Provides
    fun provideApiProfile(retrofit: Retrofit) = retrofit.create(ApiProfile::class.java)
}
