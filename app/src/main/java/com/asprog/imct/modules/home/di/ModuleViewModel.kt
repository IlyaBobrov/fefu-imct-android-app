package com.asprog.imct.modules.home.di

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules.home.services.api.ApiHome
import com.asprog.imct.modules.home.services.apiService.ApiServiceHome
import com.asprog.imct.modules.home.services.data.DataServiceHome
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ModuleViewModel {

    @Provides
    fun provideDataServiceBrands(db: AppDatabase, preferences: AppPreferences) =
        DataServiceHome(db, preferences)

    @Provides
    fun provideApiServiceBrands(api: ApiHome) = ApiServiceHome(api)
}