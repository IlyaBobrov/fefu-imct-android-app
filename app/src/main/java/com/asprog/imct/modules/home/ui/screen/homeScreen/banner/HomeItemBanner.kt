package com.asprog.imct.modules.home.ui.screen.homeScreen.banner

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.asprog.imct.modules._common.ui.compose.CommonLoading
import com.asprog.imct.modules.home.data.models.HomeBannerModel
import com.asprog.imct.modules.home.ui.events.HomeEvents
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun HomeItemBanner(
    banner: HomeBannerModel,
    onEvent: (HomeEvents) -> Unit = {},
) {

    val context = LocalContext.current
    var loading: Boolean by remember { mutableStateOf(false) }
    val intent = remember {
        Intent(Intent.ACTION_VIEW, Uri.parse(banner.url))
    }
    Box {
        CommonLoading(
            visibility = loading,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
        )

        Image(
            contentScale = ContentScale.Crop,
            painter = rememberImagePainter(banner.image, onExecute = { previous, current ->
                loading = current.state is ImagePainter.State.Empty
                ImagePainter.ExecuteCallback.Default.invoke(previous, current)
            }),
            contentDescription = banner.url,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )
        if (!loading && banner.url.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = true),
                        onClick = {
                            context.startActivity(intent)
                        }
                    )
            )
        }
    }
}