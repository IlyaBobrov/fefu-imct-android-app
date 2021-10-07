package com.asprog.imct.modules.other.service.data

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.BaseDataService
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules.other.service.data.impl.DataOtherModel

class DataServiceOther(
    override val db: AppDatabase,
    override val preferences: AppPreferences,
) : BaseDataService<DataServiceOther>,
    DataOtherModel