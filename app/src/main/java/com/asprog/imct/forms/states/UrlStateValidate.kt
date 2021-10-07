package com.asprog.imct.forms.states

import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.valid.getErrorIsNotUrl

class UrlStateValidate : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsNotUrl(target),
    )
})