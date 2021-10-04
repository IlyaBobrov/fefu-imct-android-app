package com.asprog.imct.modules.profile.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.asprog.imct.R
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.extensions.ListenRefresh
import com.asprog.imct.extensions.sizeSmall
import com.asprog.imct.modules._common.data.UserModel
import com.asprog.imct.modules._common.ui.compose.LoadingScreen
import com.asprog.imct.modules._common.ui.compose.MainScaffoldSearch
import com.asprog.imct.modules._common.ui.compose.TopBarContentTitle
import com.asprog.imct.modules.profile.navigation.nav.ProfileNav
import com.asprog.imct.modules.profile.ui.event.ProfileEvents
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun ProfileBody(
    user: Any?,
    isLogin: Boolean,
    loading: Boolean,
    onEvent: (ProfileEvents) -> Unit = {},
) {
    LocalBaseViewModel.current.ListenRefresh {
        if (it == ProfileNav.MainNav.ProfileScreen.route && isLogin) onEvent(ProfileEvents.UpdateUser)
    }

    LaunchedEffect(user) {
        if (isLogin && user == null) onEvent(ProfileEvents.UpdateUser)
    }

    MainScaffoldSearch(
        contentTitle = {
            TopBarContentTitle(stringResource(id = R.string.menu_cabinet))
        },
    ) {
        SwipeRefresh(
            swipeEnabled = isLogin,
            state = rememberSwipeRefreshState(loading),
            onRefresh = {
                onEvent(ProfileEvents.UpdateUser)
            },
            indicator = { st, tr ->
                SwipeRefreshIndicator(
                    state = st,
                    refreshTriggerDistance = tr,
                    contentColor = MaterialTheme.colors.onPrimary,
                )
            },
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .background(MaterialTheme.colors.background)
                    .fillMaxSize()
            ) {

                if (isLogin) {
                    /*ProfileAddCardBody(
                        onEvent = onEvent
                    )*/
                } else {
                    ProfileLoginBody(
                        onEvent = onEvent
                    )
                }

                Spacer(modifier = Modifier.sizeSmall())

                if (isLogin) {
                    Card(
                        shape = MaterialTheme.shapes.medium,
                        elevation = 12.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable(onClick = {

                            })
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_common_default_image_user),
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .size(48.dp)
                            )
                            Column {
                                Text(
                                    color = MaterialTheme.colors.onBackground,
                                    text = if (user is UserModel) user.name else "",
                                    modifier = Modifier
                                        .padding(start = 16.dp, end = 16.dp)
                                )
                            }
                        }
                    }
                }

                /*Spacer(modifier = Modifier.sizeSmall())

                ProfileListBody(
                    isLogin = isLogin,
                    onEvent = onEvent
                )*/
            }

            if (loading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    LoadingScreen(loading)
                }
            }
        }

    }
}