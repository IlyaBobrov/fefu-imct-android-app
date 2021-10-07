package com.asprog.imct.forms.states

import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.valid.getErrorIsBlank
import com.asprog.imct.forms.valid.getErrorIsNotUrl

class UrlStateValidateRequired : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsBlank(target),
        getErrorIsNotUrl(target),
    )
})