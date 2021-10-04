package com.asprog.imct.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

/*private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    *//* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    *//*
)*/

/*@Composable
fun ImctTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}*/

val DarkColorPalette: @Composable () -> Colors by lazy {
    { parseConfigPalette(false) }
}

val LightColorPalette: @Composable () -> Colors by lazy {
    { parseConfigPalette(true) }
}

@Composable
fun MyTheme(content: @Composable () -> Unit) {

    val colors = if (isSystemInDarkTheme()) {
        DarkColorPalette()
    } else {
        LightColorPalette()
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

// custom palette colors
val DarkColorCustomPalette: @Composable () -> CustomColors by lazy {
    { parseConfigCustomPalette(false) }
}

val LightColorCustomPalette: @Composable () -> CustomColors by lazy {
    { parseConfigCustomPalette(true) }
}

object MaterialThemeCustom {
    val colors: CustomColors
        @Composable
        get() {
            return if (isSystemInDarkTheme()) {
                DarkColorCustomPalette()
            } else {
                LightColorCustomPalette()
            }
        }
}