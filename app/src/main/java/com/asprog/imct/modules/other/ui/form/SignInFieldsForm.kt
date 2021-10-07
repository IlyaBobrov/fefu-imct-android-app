package com.asprog.imct.modules.other.ui.form

import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.base.FormStates
import com.asprog.imct.forms.states.EmailStateValidateRequired
import com.asprog.imct.modules._common.ui.forms.PasswordStateValidateRequired

enum class SignInFieldsForm(val state: FormFieldState) : FormStates {
    SignInEmail(EmailStateValidateRequired()),
    SignInPassword(PasswordStateValidateRequired()),
    SignInPhoneEmoji(FormFieldState()),
    SignInPhoneUA(FormFieldState()),
    SignInPhoneRU(FormFieldState()),
    SignInPhoneCustom(FormFieldState()),
    SignInCard(FormFieldState()),
}