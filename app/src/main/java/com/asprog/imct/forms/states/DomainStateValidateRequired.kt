package com.asprog.imct.forms.states

import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.valid.getErrorIsBlank
import com.asprog.imct.forms.valid.getErrorIsNotDomain

class DomainStateValidateRequired : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsBlank(target),
        getErrorIsNotDomain(target),
    )
})