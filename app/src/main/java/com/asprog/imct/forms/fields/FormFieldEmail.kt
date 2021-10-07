package com.asprog.imct.forms.fields

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.asprog.imct.R
import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.states.EmailStateValidate

@Composable
fun FormFieldEmail(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String = stringResource(id = R.string.form_fields_email),
    textStyle: TextStyle = LocalTextStyle.current,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions(),
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    state: FormFieldState = remember { EmailStateValidate() },
    filter: String? = null,
    maxLines: Int = 1,
    singleLine: Boolean = true,
    maxLength: Int? = null,
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
    filter = filter,
    maxLines = maxLines,
    singleLine = singleLine,
    maxLength = maxLength,
    placeholder = placeholder,
    keyboardType = KeyboardType.Email,
    contentError = contentError,
)