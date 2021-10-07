package com.asprog.imct.forms.base

import androidx.compose.ui.text.input.TextFieldValue

interface FormStates

class FormFieldsState {

    private val states = mutableMapOf<FormStates, FormFieldState>()

    fun add(key: FormStates, state: FormFieldState, value: String? = null) {
        states[key] = state
        value?.let { state.text = TextFieldValue(text = it) }
    }

    fun remove(key: FormStates) {
        states.remove(key)
    }

    fun get(key: FormStates): FormFieldState {
        return states[key]!!
    }

    fun validate() {
        var isFocus = false
        states.forEach {
            it.value.validate()
            if (!isFocus && it.value.hasErrors) {
                it.value.requestFocus()
                isFocus = true
            }
        }
    }

    fun clearError() {
        states.forEach { it.value.clearError() }
    }

    fun hasErrors(): Boolean {
        return states.count { it.value.hasErrors } > 0
    }

    fun clear() {
        return states.forEach { it.value.clear() }
    }
}