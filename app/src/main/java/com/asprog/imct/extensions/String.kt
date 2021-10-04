package com.asprog.imct.extensions

import androidx.compose.ui.graphics.Color

fun String.toColor(): Color {
    return Color(
        when {
            this.contains("0xFF") -> android.graphics.Color.parseColor("#" + this.removePrefix("0xFF"))
            this.contains("#") -> android.graphics.Color.parseColor(this)
            else -> android.graphics.Color.parseColor("#$this")
        }
    )
}