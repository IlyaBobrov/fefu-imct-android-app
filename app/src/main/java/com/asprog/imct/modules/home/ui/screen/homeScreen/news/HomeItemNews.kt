package com.asprog.imct.modules.home.ui.screen.homeScreen.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.asprog.imct.modules._common.ui.compose.CommonLoading
import com.asprog.imct.modules.home.data.models.HomeNewsModel
import com.asprog.imct.modules.home.ui.events.HomeEvents
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun HomeItemNews(news: HomeNewsModel, onEvent: (HomeEvents) -> Unit) {
    val context = LocalContext.current
    var loading: Boolean by remember { mutableStateOf(false) }

    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 200.dp)
            .padding(
                top = 10.dp,
                bottom = 2.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
//                    onEvent(HomeEvents.NavigateToNews)
                    /*onEvent(HomeEvents.NewsSingleData(
                        title = news.title
                    ))*/
                    onEvent(HomeEvents.NavigateToNewsWithArg(
                        title = news.title,
                        description = news.description,
                        image = news.images,
                        author = news.creator
                    ))
                })
                .background(Color.Transparent)

        ) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(5.dp)
                ) {
                    Text(
                        text = news.title,
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.Bold,
                        maxLines = 3,
                        fontSize = 20.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(
                    modifier = Modifier
                        .background(Color.Transparent)
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .weight(weight = 3f, fill = false)
                    ) {
                        Text(
                            text = news.description,
                            maxLines = 6,
                            fontSize = 15.sp,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Column(
                        Modifier
                            .padding(start = 5.dp, top = 5.dp)
                            .defaultMinSize(minWidth = 100.dp, minHeight = 80.dp)
                            .fillMaxWidth()
                            .width(150.dp)
                            .fillMaxHeight()
                            .height(100.dp)
                            .weight(weight = 2f, fill = false),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Card(
                            shape = MaterialTheme.shapes.large,
                            elevation = 0.dp
                        ) {
                            Box {
                                CommonLoading(
                                    visibility = loading,
                                    modifier = Modifier
                                        .size(100.dp)
                                        .align(Alignment.Center)
                                )
                                Image(
                                    contentScale = ContentScale.Crop,
                                    painter = rememberImagePainter(
                                        news.images,
                                        onExecute = { previous, current ->
                                            loading = current.state is ImagePainter.State.Empty
                                            ImagePainter.ExecuteCallback.Default.invoke(
                                                previous,
                                                current
                                            )
                                        }),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .align(Alignment.Center)
                                )
                            }
                        }
                    }
                }
            }


            /*if (!loading && news.images.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = true),
                            onClick = {
                                Toast
                                    .makeText(
                                        context,
                                        R.string.common_coming_soon,
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                        )
                )
            }*/
        }
    }
}

