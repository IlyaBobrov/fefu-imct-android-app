package com.asprog.imct.modules._common.ui.forms

import android.content.Context
import com.asprog.imct.R
import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.valid.getErrorIsBlank
import java.util.regex.Pattern


private const val PASSWORD_VALIDATION_REGEX = """^[0-9_A-z]+$"""

class PasswordStateValidateRequired : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsBlank(target),
        getErrorIsSmall(target),
        getErrorIsLong(target),
        getErrorIsNotMatches(target),
    )
})

private fun getErrorIsSmall(target: String) =
    when {
        target.length < 6 -> { it: Context ->
            it.getString(R.string.error_field_min_length, "6")
        }
        else -> null
    }

private fun getErrorIsLong(target: String) =
    when {
        target.length > 12 -> { it: Context ->
            it.getString(R.string.error_field_max_length, "12")
        }
        else -> null
    }

private fun getErrorIsNotMatches(target: String) =
    when {
        !Pattern.matches(PASSWORD_VALIDATION_REGEX, target) -> { it: Context ->
            it.getString(R.string.is_incorrect)
        }
        else -> null
    }
