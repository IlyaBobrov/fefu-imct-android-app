package com.asprog.imct.forms.fields

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.asprog.imct.R
import com.asprog.imct.forms.base.FormFieldState

@Composable
fun FormFieldPassword(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String = stringResource(id = R.string.form_fields_password),
    textStyle: TextStyle = LocalTextStyle.current,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions(),
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    state: FormFieldState = remember { FormFieldState() },
    tintIcon: Color = MaterialTheme.colors.primary,
    icVisibilityOff: Int = R.drawable.ic_visibility_off,
    icVisibilityOn: Int = R.drawable.ic_visibility,
    filter: String? = null,
    maxLength: Int? = null,
    placeholder: String? = null,
    contentError: @Composable (() -> Unit)? = null,
) {
    var visibility: Boolean by remember { mutableStateOf(false) }
    FormField(
        modifier = modifier,
        enabled = enabled,
        label = label,
        textStyle = textStyle,
        imeAction = imeAction,
        keyboardActions = keyboardActions,
        colors = colors,
        state = state,
        filter = filter,
        maxLength = maxLength,
        placeholder = placeholder,
        contentError = contentError,
        keyboardType = KeyboardType.Password,
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { visibility = !visibility }) {
                Icon(
                    painter = painterResource(id = if (visibility) icVisibilityOff else icVisibilityOn),
                    contentDescription = label,
                    tint = tintIcon
                )
            }
        },
    )
}