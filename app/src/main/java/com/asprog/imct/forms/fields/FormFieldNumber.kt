package com.asprog.imct.forms.fields

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.asprog.imct.R
import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.valid.getErrorIsNotPhone

class PhoneStateValidate : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsNotPhone(target),
    )
})

@Composable
fun FormFieldNumber(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String = stringResource(id = R.string.form_fields_phone),
    textStyle: TextStyle = LocalTextStyle.current,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions(),
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    state: FormFieldState = remember { PhoneStateValidate() },
    onValueChange: ((TextFieldValue) -> TextFieldValue)? = null,
    filter: String? = null,
    maxLines: Int = 1,
    singleLine: Boolean = true,
    maxLength: Int? = null,
    mask: String? = null,
    placeholder: String? = null,
    contentError: @Composable (() -> Unit)? = null,
) = FormField(
    modifier = modifier,
    enabled = enabled,
    label = label,
    textStyle = textStyle,
    imeAction = imeAction,
    keyboardActions = keyboardActions,
    colors = colors,
    state = state,
    onValueChange = onValueChange,
    filter = filter,
    maxLines = maxLines,
    singleLine = singleLine,
    maxLength = maxLength,
    mask = mask,
    placeholder = placeholder,
    keyboardType = KeyboardType.Number,
    contentError = contentError,
)