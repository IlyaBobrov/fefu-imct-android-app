package com.asprog.imct.modules.home.services.data

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.BaseDataService
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules.home.services.data.impl.DataHomeModel

class DataServiceHome(
    override val db: AppDatabase,
    override val preferences: AppPreferences,
) : BaseDataService<DataServiceHome>,
    DataHomeModel