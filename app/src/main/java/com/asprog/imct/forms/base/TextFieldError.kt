package com.asprog.imct.forms.base

import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextFieldError(
    text: String,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            style = LocalTextStyle.current.copy(
                color = MaterialTheme.colors.error,
                fontSize = 12.sp
            )
        )
    }
}