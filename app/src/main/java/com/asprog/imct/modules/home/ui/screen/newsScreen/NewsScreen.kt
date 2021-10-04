package com.asprog.imct.modules.home.ui.screen.newsScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.asprog.imct.R
import com.asprog.imct.modules._common.ui.compose.CommonLoading
import com.asprog.imct.modules.home.ui.events.NewsEvents
import com.asprog.imct.modules.home.ui.viewmodel.HomeNewsViewModel


@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun NewsScreen(
    viewModel: HomeNewsViewModel,
    argumentTitle: String? = null,
    argumentDescription: String? = null,
    argumentImages: String? = null,
    argumentCreator: String? = null,
    onEvent: (NewsEvents) -> Unit = {},
) {
    var loading: Boolean by remember { mutableStateOf(false) }


    Scaffold(topBar = {

        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            elevation = AppBarDefaults.TopAppBarElevation,
            title = {
                Text(
                    text = stringResource(id = R.string.news_screen_bar),
                    fontSize = TextUnit.Unspecified,
                    color = MaterialTheme.colors.onPrimary
                )
            },
            navigationIcon = {
                IconButton(onClick = { onEvent(NewsEvents.NavigateBack) }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Назад",
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            })
    }) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            if (argumentImages != null)
                Log.e("TAG", "NewsScreen: $argumentImages")
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp)
                    ) {
                        CommonLoading(
                            visibility = loading,
                            modifier = Modifier
                                .size(100.dp)
                                .align(Alignment.Center)
                        )
                        Image(
                            contentScale = ContentScale.Crop,
                            painter = rememberImagePainter(
                                argumentImages,
                                onExecute = { previous, current ->
                                    loading = current.state is ImagePainter.State.Empty
                                    ImagePainter.ExecuteCallback.Default.invoke(previous, current)
                                }),
                            contentDescription = argumentTitle,
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center)
                        )
                    }
                }
            item {
                Text(
                    text = argumentTitle ?: "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onPrimary
                )
            }
            item {
                Text(
                    text = argumentDescription ?: "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}