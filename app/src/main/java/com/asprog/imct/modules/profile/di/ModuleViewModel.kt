package com.asprog.imct.modules.profile.di

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules.profile.services.api.ApiProfile
import com.asprog.imct.modules.profile.services.apiService.ApiServiceProfile
import com.asprog.imct.modules.profile.services.data.DataServiceProfile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ModuleViewModel {

    @Provides
    fun provideDataServiceProfile(db: AppDatabase, preferences: AppPreferences) =
        DataServiceProfile(db, preferences)

    @Provides
    fun provideApiServiceProfile(api: ApiProfile) = ApiServiceProfile(api)
}
