package com.asprog.imct.modules._common.di

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules._common.service.DataServiceCommon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ModuleViewModel {
    @Provides
    fun provideDataServiceCommon(db: AppDatabase, preferences: AppPreferences) = DataServiceCommon(db, preferences)
}