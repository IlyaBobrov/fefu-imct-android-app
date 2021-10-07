package com.asprog.imct.modules.other.ui.screens.signIn


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.asprog.imct.R
import com.asprog.imct.forms.base.FormFieldsState
import com.asprog.imct.forms.fields.FormField
import com.asprog.imct.forms.fields.FormFieldEmail
import com.asprog.imct.forms.fields.FormFieldNumber
import com.asprog.imct.forms.fields.FormFieldPassword
import com.asprog.imct.modules.other.ui.events.SignInEvents
import com.asprog.imct.modules.other.ui.form.SignInFieldsForm
import com.asprog.imct.ui.theme.customTextFieldColors
import com.asprog.imct.urils.ConstantsApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInForm(
    loading: Boolean = false,
    onNavigationEvent: (SignInEvents) -> Unit = {},
) {
    val softwareKeyboardController = LocalSoftwareKeyboardController.current
    val localFocusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()
    val padding = 16.dp

    // Create from state
    val formFields = FormFieldsState().apply {
        add(SignInFieldsForm.SignInEmail, remember { SignInFieldsForm.SignInEmail.state.default(
            ConstantsApp.DEBUG_CREDENTIAL_LOGIN) })
        add(SignInFieldsForm.SignInPassword, remember { SignInFieldsForm.SignInPassword.state.default(ConstantsApp.DEBUG_CREDENTIAL_PASSW) })
        add(SignInFieldsForm.SignInPhoneEmoji, remember { SignInFieldsForm.SignInPhoneEmoji.state.default("") })
        add(SignInFieldsForm.SignInPhoneUA, remember { SignInFieldsForm.SignInPhoneUA.state.default("") })
        add(SignInFieldsForm.SignInPhoneRU, remember { SignInFieldsForm.SignInPhoneRU.state.default("") })
        add(SignInFieldsForm.SignInPhoneCustom, remember { SignInFieldsForm.SignInPhoneCustom.state.default("") })
        add(SignInFieldsForm.SignInCard, remember { SignInFieldsForm.SignInCard.state.default("") })
    }

    // For focus to field
    val requesterFieldEmail = remember { FocusRequester() }
    val requesterFieldEmoji = remember { FocusRequester() }
    val requesterFieldPhoneUA = remember { FocusRequester() }
    val requesterFieldPhoneRU = remember { FocusRequester() }
    val requesterFieldPhoneCustom = remember { FocusRequester() }
    val requesterFieldCard = remember { FocusRequester() }
    val requesterFieldPassword = remember { FocusRequester() }

    // click submit
    val submitClick = {
        // validate before send
        formFields.validate()
        // check has errors
        if (!formFields.hasErrors()) {
            // submit query
            onNavigationEvent(
                SignInEvents.SignIn(
                    login = formFields.get(SignInFieldsForm.SignInEmail).getValue(),
                    passw = formFields.get(SignInFieldsForm.SignInPassword).getValue(),
                )
            )
            // hide keyboard
            localFocusManager.clearFocus()
            softwareKeyboardController?.hide()
        }
    }

    // Create field email
    FormFieldEmail(
        modifier = Modifier.focusRequester(requesterFieldEmail),
        label = stringResource(id = R.string.form_email),
        enabled = !loading,
        state = formFields.get(SignInFieldsForm.SignInEmail),
        imeAction = ImeAction.Next,
        colors = customTextFieldColors(),
        keyboardActions = KeyboardActions(onNext = { requesterFieldEmoji.requestFocus() })
    )

    Spacer(modifier = Modifier.size(padding))

    /*FormField(
        modifier = Modifier.focusRequester(requesterFieldEmoji),
        label = stringResource(id = R.string.form_name),
        enabled = !loading,
        state = formFields.get(SignInFieldsForm.SignInPhoneEmoji),
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Ascii,
        colors = customTextFieldColors(),
        keyboardActions = KeyboardActions(onNext = { requesterFieldPhoneUA.requestFocus() }),
        filterEmoji = true
    )

    Spacer(modifier = Modifier.size(padding))*/

    /*FormFieldPhone(
        modifier = Modifier.focusRequester(requesterFieldPhoneUA),
        label = stringResource(id = R.string.form_phone),
        enabled = !loading,
        state = formFields.get(SignInPhoneUA),
        imeAction = ImeAction.Next,
        colors = customTextFieldColors(),
        keyboardActions = KeyboardActions(onNext = { requesterFieldPhoneRU.requestFocus() }),
        mask = "+380 (###) ###-##-##",
        placeholder = "+380 (000) 000-000-000",
    )

    Spacer(modifier = Modifier.size(padding))*/

    /*FormFieldPhone(
        modifier = Modifier.focusRequester(requesterFieldPhoneRU),
        label = stringResource(id = R.string.form_phone),
        enabled = !loading,
        state = formFields.get(SignInPhoneRU),
        imeAction = ImeAction.Next,
        colors = customTextFieldColors(),
        keyboardActions = KeyboardActions(onNext = { requesterFieldPhoneCustom.requestFocus() }),
        mask = "+7 (###) ###-##-##",
        placeholder = "+7 (000) 000-000-000",
    )

    Spacer(modifier = Modifier.size(padding))

    FormFieldPhone(
        modifier = Modifier.focusRequester(requesterFieldPhoneCustom),
        label = stringResource(id = R.string.form_phone),
        enabled = !loading,
        state = formFields.get(SignInPhoneCustom),
        imeAction = ImeAction.Next,
        colors = customTextFieldColors(),
        keyboardActions = KeyboardActions(onNext = { requesterFieldCard.requestFocus() }),
        mask = "+# (###) ###-##-##",
        placeholder = "+0 (000) 000-000-000",
    )

    Spacer(modifier = Modifier.size(padding))*/

    /*FormFieldNumber(
        modifier = Modifier.focusRequester(requesterFieldCard),
        label = stringResource(id = R.string.form_card),
        enabled = !loading,
        state = formFields.get(SignInFieldsForm.SignInCard),
        imeAction = ImeAction.Next,
        colors = customTextFieldColors(),
        keyboardActions = KeyboardActions(onNext = { requesterFieldPassword.requestFocus() }),
        mask = "####-####-####-####",
        placeholder = "0000-0000-0000-0000",
        filter = "123456789"
    )

    Spacer(modifier = Modifier.size(padding))*/

    // Create field password
    FormFieldPassword(
        modifier = Modifier.focusRequester(requesterFieldPassword),
        enabled = !loading,
        state = formFields.get(SignInFieldsForm.SignInPassword),
        filter = "123456789",
        maxLength = 10,
        imeAction = ImeAction.Done,
        colors = customTextFieldColors(),
        tintIcon = MaterialTheme.colors.onPrimary,
        keyboardActions = KeyboardActions(onDone = { submitClick.invoke() })
    )

    Spacer(modifier = Modifier.size(padding))

    // Submit button
    Button(
        enabled = !loading,
        onClick = { submitClick.invoke() },
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.textButtonColors(backgroundColor = MaterialTheme.colors.secondary),
    ) {
        Text(
            text = stringResource(id = R.string.form_button_submit).uppercase(),
        )
    }

    // Clear focus after end
    LaunchedEffect(Unit) {
        scope.launch {
            delay(10)
            requesterFieldEmail.requestFocus()
        }
    }
}