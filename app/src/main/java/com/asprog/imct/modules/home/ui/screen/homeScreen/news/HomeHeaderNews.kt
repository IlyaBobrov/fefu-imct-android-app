package com.asprog.imct.modules.home.ui.screen.homeScreen.news

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.asprog.imct.R
import com.asprog.imct.modules._common.ui.compose.impl.ClickableTextColorAnimation
import com.asprog.imct.modules.home.data.models.HomeNewsModel
import com.asprog.imct.modules.home.ui.events.HomeEvents

@Composable
fun HomeHeaderNews(
    news: List<HomeNewsModel>,
    onEvent: (HomeEvents) -> Unit = {},
    ) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterStart),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.screen_home_name),
            style = MaterialTheme.typography.h5,
        )

        ClickableTextColorAnimation(
            modifier = Modifier.align(Alignment.CenterEnd),
            colorDefault = MaterialTheme.colors.onBackground,
            colorAction = MaterialTheme.colors.onSurface,
            text = stringResource(id = R.string.ads_btn_all)
        ) {
            Toast.makeText(context, R.string.common_coming_soon, Toast.LENGTH_SHORT).show()
        }
    }
}