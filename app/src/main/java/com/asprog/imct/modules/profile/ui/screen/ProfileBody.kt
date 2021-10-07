package com.asprog.imct.modules.profile.ui.screen

import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.asprog.imct.R
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.extensions.ListenRefresh
import com.asprog.imct.extensions.sizeSmall
import com.asprog.imct.modules._common.ui.compose.LoadingScreen
import com.asprog.imct.modules._common.ui.compose.MainScaffoldSearch
import com.asprog.imct.modules._common.ui.compose.TopBarContentTitle
import com.asprog.imct.modules.other.data.resp.UserResp
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
    userResp: UserResp,
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
                    ShowProfileInfo(user, isLogin, userResp, onEvent)
                }

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

@Composable
fun ShowProfileInfo(
    user: Any?,
    isLogin: Boolean,
    userResp: UserResp,
    onEvent: (ProfileEvents) -> Unit
) {
    val context = LocalContext.current
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = 12.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = {
                Toast
                    .makeText(context, "Скоро будет...", Toast.LENGTH_SHORT)
                    .show()
            })
    ) {
        Column(Modifier.fillMaxWidth()) {

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
                        text = userResp.name,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_profile_menu_list_contact_us),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .size(48.dp)
                )
                Column {
                    Text(
                        color = MaterialTheme.colors.onBackground,
                        text = userResp.email,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_profile_menu_list_contacts),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .size(48.dp)
                )
                Column {
                    Log.e("TAG", "ShowProfileInfo: role: ${userResp.role}")
                    Text(
                        color = MaterialTheme.colors.onBackground,
                        text = when (userResp.role) {
                            0 -> "Студент"
                            1 -> "Преподаватель (Ожидается подтверждение)"
                            2 -> "Преподаватель"
                            3 -> "Администратор"
                            else -> "Гость"
                        },
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                    )
                }
            }
        }
    }
    ProfileListBody(isLogin, userResp, onEvent)
}

const val keyIcon = "keyIcon"
const val keyName = "keyName"
const val keyAction = "keyAction"

@Composable
fun ProfileListBody(
    isLogin: Boolean,
    userResp: UserResp,
    onEvent: (ProfileEvents) -> Unit = {},
) {
    Column {
        mutableListOf<Map<String, Any>>().apply {
            /*add(
                mapOf(
                    keyIcon to painterResource(R.drawable.ic_profile_menu_list_loyalty),
                    keyName to stringResource(id = R.string.profile_menu_list_loyalty),
                    keyAction to {
                        Timber.e("Click")
                    },
                ),
            )*/

            if (isLogin) {
                when (userResp.role) {
                    0, 1 -> {
                        add(
                            mapOf(
                                keyIcon to painterResource(R.drawable.ic_profile_menu_list_loyalty),
                                keyName to "Предложить новость",
                                keyAction to {
                                    /*onEvent(ProfileEvents.NavigateToContactSettings)*/
                                },
                            ),
                        )
                    }
                    2, 3 -> {
                        add(
                            mapOf(
                                keyIcon to painterResource(R.drawable.ic_profile_menu_list_loyalty),
                                keyName to "Создать новость",
                                keyAction to {
                                    /*onEvent(ProfileEvents.NavigateToContactSettings)*/
                                },
                            ),
                        )
                        add(
                            mapOf(
                                keyIcon to painterResource(R.drawable.ic_profile_menu_list_contacts),
                                keyName to "Создать объявление",
                                keyAction to {
                                    /*Timber.e("Click")*/
                                },
                            ),
                        )
                        add(
                            mapOf(
                                keyIcon to painterResource(R.drawable.ic_profile_menu_list_purchased),
                                keyName to "Создать рассылку",
                                keyAction to {
                                    /*Timber.e("Click")*/
                                },
                            ),
                        )
                    }
                }
                if (userResp.role == 3) {
                    add(
                        mapOf(
                            keyIcon to painterResource(R.drawable.ic_profile_menu_list_loyalty),
                            keyName to "Предложенные новости",
                            keyAction to {
                                /*onEvent(ProfileEvents.NavigateToContactSettings)*/
                            },
                        ),
                    )
                    add(
                        mapOf(
                            keyIcon to painterResource(R.drawable.ic_profile_popup),
                            keyName to "Подтверждение преподавателей",
                            keyAction to {
                                /*Timber.e("Click")*/
                            },
                        ),
                    )
                }
                add(
                    mapOf(
                        keyIcon to painterResource(R.drawable.ic_profile_menu_list_logout),
                        keyName to stringResource(id = R.string.profile_menu_list_logout),
                        keyAction to {
                            onEvent(ProfileEvents.NavigateLogout)
                        },
                    ),
                )
            }
        }.forEach { item ->
            ProfileListBodyItem(item = item)
        }
    }
}

@Composable
fun ShowDevMsg() {
    val context = LocalContext.current
    Toast.makeText(context, "Скоро будет!", Toast.LENGTH_SHORT).show()
}

@Composable
fun ProfileListBodyItem(
    item: Map<String, Any>,
) {
    val context = LocalContext.current
    Card(
        shape = MaterialTheme.shapes.large,
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp, end = 5.dp, start = 5.dp)
            .clickable(
                onClick = item[keyAction] as () -> Unit
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .size(48.dp)
                    .background(Color.White)
            ) {
                Image(
                    painter = item[keyIcon] as Painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .align(Alignment.Center)
                )
            }
            Column {
                Text(
                    color = MaterialTheme.colors.onBackground,
                    text = item[keyName] as String,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                )
            }
        }
    }
}