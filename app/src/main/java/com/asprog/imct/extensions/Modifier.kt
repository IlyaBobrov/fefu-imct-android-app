package com.asprog.imct.extensions

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object ModifierConfiguration {

    internal var xSmall: Dp = 2.dp
    internal var small: Dp = 4.dp
    internal var medium: Dp = 8.dp
    internal var large: Dp = 16.dp
    internal var xLarge: Dp = 24.dp
    internal var xLarge2: Dp = 48.dp
    internal var xLarge3: Dp = 96.dp

    fun init(
        xSmall: Dp = ModifierConfiguration.xSmall,
        small: Dp = ModifierConfiguration.small,
        medium: Dp = ModifierConfiguration.medium,
        large: Dp = ModifierConfiguration.large,
        xLarge: Dp = ModifierConfiguration.xLarge,
        xLarge2: Dp = ModifierConfiguration.xLarge2,
        xLarge3: Dp = ModifierConfiguration.xLarge3
    ) {
        this.xSmall = xSmall
        this.small = small
        this.medium = medium
        this.large = large
        this.xLarge = xLarge
        this.xLarge2 = xLarge2
        this.xLarge3 = xLarge3
    }
}

fun Modifier.visible(visibility: Boolean): Modifier = this.then(alpha(if (visibility) 1f else 0f))


fun Modifier.paddingXSmall(): Modifier = this.then(padding(ModifierConfiguration.xSmall))

fun Modifier.paddingSmall(): Modifier = this.then(padding(ModifierConfiguration.small))

fun Modifier.paddingMedium(): Modifier = this.then(padding(ModifierConfiguration.medium))

fun Modifier.paddingLarge(): Modifier = this.then(padding(ModifierConfiguration.large))

fun Modifier.paddingXLarge(): Modifier = this.then(padding(ModifierConfiguration.xLarge))

fun Modifier.paddingXLarge2(): Modifier = this.then(padding(ModifierConfiguration.xLarge2))

fun Modifier.paddingXLarge3(): Modifier = this.then(padding(ModifierConfiguration.xLarge3))


fun Modifier.sizeXSmall(): Modifier = this.then(size(ModifierConfiguration.xSmall))

fun Modifier.sizeSmall(): Modifier = this.then(size(ModifierConfiguration.small))

fun Modifier.sizeMedium(): Modifier = this.then(size(ModifierConfiguration.medium))

fun Modifier.sizeLarge(): Modifier = this.then(size(ModifierConfiguration.large))

fun Modifier.sizeXLarge(): Modifier = this.then(size(ModifierConfiguration.xLarge))

fun Modifier.sizeXLarge2(): Modifier = this.then(size(ModifierConfiguration.xLarge2))

fun Modifier.sizeXLarge3(): Modifier = this.then(size(ModifierConfiguration.xLarge3))