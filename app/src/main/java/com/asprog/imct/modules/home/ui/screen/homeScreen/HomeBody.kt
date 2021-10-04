package com.asprog.imct.modules.home.ui.screen.homeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import com.asprog.imct.R
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.extensions.ListenRefresh
import com.asprog.imct.modules._common.ui.compose.EmptyListScreen
import com.asprog.imct.modules._common.ui.compose.LoadingScreen
import com.asprog.imct.modules._common.ui.compose.MainScaffoldSearch
import com.asprog.imct.modules._common.ui.compose.TopBarContentTitle
import com.asprog.imct.modules.home.data.relations.HomeRelation
import com.asprog.imct.modules.home.navigation.nav.HomeNav
import com.asprog.imct.modules.home.ui.events.HomeEvents
import com.asprog.imct.modules.home.ui.screen.homeScreen.ads.HomeItemAds
import com.asprog.imct.modules.home.ui.screen.homeScreen.banner.HomeItemBanners
import com.asprog.imct.modules.home.ui.screen.homeScreen.news.HomeHeaderNews
import com.asprog.imct.modules.home.ui.screen.homeScreen.news.HomeItemNews
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import timber.log.Timber

@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun HomeBody(
    home: Any?,
    commonError: String? = null,
    loading: Boolean = true,
    onEvent: (HomeEvents) -> Unit = {}
) {

    MainScaffoldSearch(
        searchDescription = stringResource(id = R.string.common_search),
        navigationIconDescription = stringResource(R.string.common_navigate_up),
        contentTitle = {
            TopBarContentTitle(stringResource(id = R.string.screen_home_name))
        },
        searchListener = { search ->
            Timber.e(search)
        },
        closeSearchListener = {
            Timber.e("Close")
        }
    ) {
        LocalBaseViewModel.current.ListenRefresh {
            if (it == HomeNav.MainNav.HomeScreen.route) onEvent(HomeEvents.RefreshHome)
        }

        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = loading),
            onRefresh = { onEvent(HomeEvents.RefreshHome) },
            indicator = { st, tr ->
                SwipeRefreshIndicator(
                    state = st,
                    refreshTriggerDistance = tr,
                    contentColor = MaterialTheme.colors.onPrimary
                )
            },
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {

            when (home) {
                is HomeRelation -> {
                    Timber.e("is HomeRelation")
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        item {
                            HomeItemBanners(
                                banners = home.banners,
                                onEvent = onEvent
                            )
                        }
                        item {
                            HomeItemAds(
                                name = stringResource(id = R.string.home_ads_title),
                                ads = home.ads,
                                onEvent = onEvent
                            )
                        }
                        item { HomeHeaderNews(news = home.news, onEvent = onEvent) }
                        home.news.forEach { newsItem ->
                            item { HomeItemNews(news = newsItem, onEvent = onEvent) }
                        }
                    }
                }
                is Boolean -> {
                    LaunchedEffect(home) {
                        Timber.e("Initial data")
                    }
                }
                else -> {
                    if (!loading) {
                        EmptyListScreen(
                            text = stringResource(id = R.string.home_empty_feed),
                            painter = painterResource(id = R.drawable.ic_launcher_foreground)
                        )
                    } else {
                        LoadingScreen(loading)
                    }
                }
            }

        }
    }

}


