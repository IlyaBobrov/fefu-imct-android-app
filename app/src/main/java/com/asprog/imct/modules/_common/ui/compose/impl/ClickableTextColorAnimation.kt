package com.asprog.imct.modules._common.ui.compose.impl

import androidx.compose.animation.Animatable
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ClickableTextColorAnimation(
    modifier: Modifier = Modifier,
    colorDefault: Color,
    colorAction: Color,
    text: String,
    delay: Long = 500,
    style: TextStyle = TextStyle.Default,
    underline: Boolean = false,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    var click: Boolean by remember { mutableStateOf(false) }
    val color = remember { Animatable(colorDefault) }

    ClickableText(
        modifier = modifier,
        style = style.copy(textDecoration = if (underline) TextDecoration.Underline else TextDecoration.None),
        softWrap = softWrap,
        overflow = overflow,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = color.value,
                )
            ) {
                append(text)
            }
        },
    ) {
        click = true
        scope.launch {
            delay(delay)
            onClick.invoke()
            click = false
        }
    }

    LaunchedEffect(click) {
        color.animateTo(if (click) colorAction else colorDefault)
    }
}