package com.asprog.imct.modules._common.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormError(
    modifier: Modifier = Modifier,
    textError: String = "Box Text Field Error Preview, Box Text Field Error Preview, Box Text Field Error Preview, Box Text Field Error Preview,Box Text Field Error Preview",
) {
    Card(
        elevation = 4.dp,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.error)
        ) {
            Text(
                text = textError,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                style = LocalTextStyle.current.copy(
                    color = Color.White,
                    fontSize = 12.sp
                )
            )
        }
    }
}