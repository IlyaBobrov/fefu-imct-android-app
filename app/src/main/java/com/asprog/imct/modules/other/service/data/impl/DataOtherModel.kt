package com.asprog.imct.modules.other.service.data.impl

import com.asprog.imct.base.AppDatabase
import com.asprog.imct.base.preferences.AppPreferences


interface DataOtherModel {
    val db: AppDatabase
    val preferences: AppPreferences
}