package com.asprog.imct.forms.states

import com.asprog.imct.forms.base.FormFieldState
import com.asprog.imct.forms.valid.getErrorIsNotDomain

class DomainStateValidate : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsNotDomain(target),
    )
})