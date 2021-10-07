package com.asprog.imct.forms.valid

import android.content.Context
import android.util.Patterns
import com.asprog.imct.R

fun getErrorIsNotEmail(target: String) = when {
    !Patterns.EMAIL_ADDRESS.matcher(target).matches() -> { it: Context ->
        it.getString(R.string.validate_is_incorrect)
    }
    else -> null
}