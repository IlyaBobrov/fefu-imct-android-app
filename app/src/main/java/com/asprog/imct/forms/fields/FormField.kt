package com.asprog.imct.forms.fields

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.*
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.relocationRequester
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asprog.imct.R
import com.asprog.imct.forms.base.*
import com.google.accompanist.insets.*
import com.vdurmont.emoji.EmojiParser
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FormField(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    imeAction: ImeAction = ImeAction.Next,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions(),
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    state: FormFieldState = remember { FormFieldState() },
    onValueChange: ((TextFieldValue) -> TextFieldValue)? = null,
    filter: String? = null,
    filterEmoji: Boolean = false,
    lines: Int? = null,
    maxLines: Int = 1,
    singleLine: Boolean = true,
    maxLength: Int? = null,
    mask: String? = null,
    placeholder: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    contentError: @Composable (() -> Unit)? = null,
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val sizeDp = with(LocalDensity.current) {
        textStyle.fontSize.value.sp.toDp() + 3.dp /* space */
    }

    // clear focus if keyboard hide
    val ime = LocalWindowInsets.current.ime
    val localFocusManager = LocalFocusManager.current

    LaunchedEffect(ime.isVisible) {
        if (!ime.isVisible) {
            // clear focuses
            localFocusManager.clearFocus()
        }
    }

    TextField(
        maxLines = maxLines,
        singleLine = singleLine,
        enabled = enabled,
        readOnly = readOnly,
        value = state.text,
        textStyle = textStyle,
        visualTransformation = visualTransformation,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        onValueChange = { textFieldValue ->
            // filter
            var value = filter?.let {
                val filterWithMask = mask?.let { mask + filter } ?: filter
                textFieldValue.copy(text = textFieldValue.text.filter { c -> filterWithMask.contains(c) })
            } ?: textFieldValue

            // filter Emoji
            if (filterEmoji) {
                EmojiParser.removeAllEmojis(value.text)?.let {
                    if (it.length != value.text.length) {
                        scope.launch {
                            Toast.makeText(context, "form_error_emoji", Toast.LENGTH_SHORT).show()
                        }
                        value = value.copy(text = it)
                    }
                }
            }

            // maxLength
            if (value.text.length > maxLength ?: Int.MAX_VALUE) {
                return@TextField
            }

            mask?.let {
                // mask
                state.text = onValueChangeMask.invoke(mask, state, value)
            } ?: run {
                // custom or default
                state.text = onValueChange?.invoke(value) ?: value
            }
        },
        label = label?.let {
            {
                Text(label)
            }
        },
        placeholder = placeholder?.let { { Text(placeholder) } },
        modifier = modifier
            .defaultMinSize(minHeight = lines?.let {
                sizeDp
                    .times(lines)
                    .plus(40.dp /* body field */)
            }
                ?: Dp.Unspecified)
            .fillMaxWidth()
            .focusRequester(state.focus)
            .relocationRequester(state.relocation)
            .onFocusChanged { focusState ->
                if (focusState.isFocused) {
                    // to end position
                    state.positionToEnd()
                    // focus to input
                    scope.launch {
                        delay(300) // keyboard change
                        state.bringIntoView()
                    }
                }
            },
        isError = state.hasErrors,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = keyboardActions,
        colors = colors
    )

    state.getError(LocalContext.current)?.let { error ->
        contentError?.invoke() ?: TextFieldError(text = error)
    }
}