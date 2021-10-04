package com.asprog.imct.modules._common.ui.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.asprog.imct.R
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.modules._common.navigation.HomeTab
import com.asprog.imct.modules._common.navigation.NavActions
import com.asprog.imct.ui.theme.MaterialThemeCustom
import com.asprog.imct.ui.theme.MyTheme
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun BottomBar(
    navActions: NavActions,
    currentRoute: HomeTab = HomeTab.HOME,
) {
    val baseViewModel = LocalBaseViewModel.current

    if (HomeTab.values().any { it.route == currentRoute.route }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            BottomNavigation(
                modifier = Modifier.navigationBarsHeight(56.dp),
                backgroundColor = colorResource(id = R.color.primary)
            ) {
                HomeTab.values().forEach { tab ->
                    BottomNavigationItem(
                        label = {
                            Text(text = stringResource(id = tab.label),
                                color = with(MaterialThemeCustom.colors) { if (tab.route == currentRoute.route) tabEnable else tabDisable })
                        },
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = null,
                                tint = with(MaterialThemeCustom.colors) { if (tab.route == currentRoute.route) tabEnable else tabDisable }
                            )
                        },
                        selected = tab.route == currentRoute.route,
                        onClick = {
                            if (currentRoute == tab) {
//                                baseViewModel.listRefresh()
                            } else {
                                when (tab) {
                                    HomeTab.HOME -> navActions.navigateToHome()
                                    HomeTab.INFO -> navActions.navigateToInfo()
                                    HomeTab.PROFILE -> navActions.navigateToProfile()
                                }
                            }
                        },
                        selectedContentColor = MaterialTheme.colors.onSurface,
                        unselectedContentColor = MaterialTheme.colors.onSurface,
                        modifier = Modifier.navigationBarsPadding()
                    )
                }
            }
        }
    }
}

@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomBarPreview() {
    MyTheme {
        Surface {
            BottomBar(navActions = NavActions(rememberNavController()))
        }
    }
}