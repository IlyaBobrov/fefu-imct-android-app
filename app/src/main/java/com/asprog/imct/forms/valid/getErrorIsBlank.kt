package com.asprog.imct.forms.valid

import android.content.Context
import com.asprog.imct.R

fun getErrorIsBlank(target: String) =
    when {
        target.isBlank() -> { it: Context ->
            it.getString(R.string.validate_is_required)
        }
        else -> null
    }