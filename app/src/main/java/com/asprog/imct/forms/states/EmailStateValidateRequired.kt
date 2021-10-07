package com.asprog.imct.forms.states

import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.valid.getErrorIsBlank
import com.asprog.imct.forms.valid.getErrorIsNotEmail

class EmailStateValidateRequired : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsBlank(target),
        getErrorIsNotEmail(target),
    )
})
