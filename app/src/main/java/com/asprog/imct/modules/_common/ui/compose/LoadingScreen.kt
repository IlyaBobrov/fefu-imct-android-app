package com.asprog.imct.modules._common.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.asprog.imct.R

@Composable
fun LoadingScreen(
    visibility: Boolean,
) {
    Box {
        when (remember { (0..1).random() }) {
            0 -> CoastLoadingScreen(visibility = visibility)
            1 -> BooksLoadingScreen(visibility = visibility)
        }
    }
}

@Composable
fun BoxScope.CoastLoadingScreen(
    visibility: Boolean,
) {
    val coastComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.lotte_fefu),
    )

    val progress by animateLottieCompositionAsState(
        composition = coastComposition,
        iterations = LottieConstants.IterateForever
    )

    if (visibility) {
        LottieAnimation(
            composition = coastComposition,
            progress = progress,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(30.dp)
        )
    }
}

@Composable
fun BoxScope.BooksLoadingScreen(
    visibility: Boolean,
) {
    val bookComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.lotte_books),
    )

    val progress by animateLottieCompositionAsState(
        composition = bookComposition,
        iterations = LottieConstants.IterateForever
    )

    if (visibility) {
        Box {
            LottieAnimation(
                composition = bookComposition,
                progress = progress,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(30.dp)
            )
        }
    }
}