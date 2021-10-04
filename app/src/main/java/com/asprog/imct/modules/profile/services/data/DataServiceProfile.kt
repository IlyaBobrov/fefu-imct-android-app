package com.asprog.imct.modules.profile.services.data

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.BaseDataService
import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.modules.profile.services.data.impl.DataUserContactsModel
import com.asprog.imct.modules.profile.services.data.impl.DataUserModel


class DataServiceProfile(
    override val db: AppDatabase,
    override val preferences: AppPreferences,
) : BaseDataService<DataServiceProfile>,
    DataUserContactsModel,
    DataUserModel