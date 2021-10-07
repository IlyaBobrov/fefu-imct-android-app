package com.asprog.imct.modules.other.di

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules.other.service.api.ApiOther
import com.asprog.imct.modules.other.service.apiService.ApiServiceOther
import com.asprog.imct.modules.other.service.data.DataServiceOther
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ModuleViewModel {

    @Provides
    fun provideDataServiceOther(db: AppDatabase, preferences: AppPreferences) =
        DataServiceOther(db, preferences)

    @Provides
    fun provideApiServiceOther(api: ApiOther) = ApiServiceOther(api)
}
