package com.asprog.imct.modules.home.ui.screen.homeScreen.banner

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.modules.home.data.models.HomeBannerModel
import com.asprog.imct.modules.home.ui.events.HomeEvents
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import timber.log.Timber

@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun HomeItemBanners(
    banners: List<HomeBannerModel> = listOf(),
    onEvent: (HomeEvents) -> Unit = {},
) {
    Timber.e("HomeItemBanners")
    Timber.e("banners: $banners")
    if (banners.isNotEmpty()) {
        Timber.e("banners.isNotEmpty")

        val pagerState = rememberPagerState(pageCount = banners.size)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        ) {
            HorizontalPager(
                state = pagerState,
            ) { page ->
                HomeItemBanner(banners[page])
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            )
        }
    }
}