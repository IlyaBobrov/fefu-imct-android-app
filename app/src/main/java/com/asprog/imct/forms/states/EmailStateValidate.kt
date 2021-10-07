package com.asprog.imct.forms.states

import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.valid.getErrorIsNotEmail

class EmailStateValidate : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsNotEmail(target),
    )
})