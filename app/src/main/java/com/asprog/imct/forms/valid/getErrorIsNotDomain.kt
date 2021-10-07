package com.asprog.imct.forms.valid

import android.content.Context
import android.util.Patterns
import com.asprog.imct.R

fun getErrorIsNotDomain(target: String) = when {
    !Patterns.DOMAIN_NAME.matcher(target).matches() -> { it: Context ->
        it.getString(R.string.validate_is_incorrect)
    }
    else -> null
}