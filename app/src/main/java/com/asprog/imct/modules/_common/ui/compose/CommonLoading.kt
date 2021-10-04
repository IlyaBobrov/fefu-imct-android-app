package com.asprog.imct.modules._common.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.*
import com.asprog.imct.R

@Composable
fun CommonLoading(
    visibility: Boolean,
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.lotte_fefu),
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    if (visibility) {
        Box(modifier = modifier) {
            LottieAnimation(
                composition = composition,
                progress = progress,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}