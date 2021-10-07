package com.asprog.imct.modules.info.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.airbnb.lottie.compose.*
import com.asprog.imct.R
import com.asprog.imct.modules.info.data.responses.DepartmentResponse
import com.asprog.imct.modules.info.data.responses.DirectionsResponse
import com.asprog.imct.modules.info.data.responses.InfoResponse
import com.asprog.imct.modules.info.data.responses.TeachersResponse
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalCoilApi::class)
@ExperimentalPagerApi
@Composable
fun InfoScreenContentAndError(data: InfoResponse?, isShowError: Boolean) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        state = scrollState
    ) {
        item {
            PostDep(data?.department)
        }
        item {
            PostDepDirections(data?.directions)
        }
        item {
            PostDepTeachers(data?.teachers)
        }
    }
}

@ExperimentalCoilApi
@ExperimentalPagerApi
@Composable
fun PostDepTeachers(teachers: List<TeachersResponse>?) {
    Column() {
        HeaderInfo("Преподаватели департамента", 60)
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            for (i in 0..19) {
                item {
                    InfoItemTeacher(teachers!![i])
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            for (i in 20..39) {
                item {
                    InfoItemTeacher(teachers!![i])
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            for (i in 40..59) {
                item {
                    InfoItemTeacher(teachers!![i])
                }
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun InfoItemTeacher(teacher: TeachersResponse) {
    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(start = 5.dp, end = 5.dp, top = 10.dp)
                            .size(100.dp, 100.dp),
                        shape = RoundedCornerShape(100.dp),
                        elevation = 0.dp
                    ) {
                        Image(
                            contentScale = ContentScale.Crop,
                            painter = rememberImagePainter(
                                teacher.imageUrl
                            ),
                            modifier = Modifier.fillMaxSize(),
                            alignment = Alignment.Center,
                            contentDescription = teacher.imageUrl
                        )
                    }
                }
            },
            text = {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = teacher.name ?: "",
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                    }) {
                    Text(stringResource(id = R.string.close_dialog))
                }
            }
        )
    }


    Card(
        modifier = Modifier
            .padding(5.dp)
            .width(130.dp)
            .height(185.dp)
            .clickable(onClick = {
                openDialog.value = true
            }),
        elevation = 1.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp, top = 10.dp)
                    .size(100.dp, 100.dp),
                shape = RoundedCornerShape(100.dp),
                elevation = 0.dp
            ) {


                Image(
                    contentScale = ContentScale.Crop,
                    painter = rememberImagePainter(
                        teacher.imageUrl
                    ),
                    modifier = Modifier.fillMaxSize(),
                    alignment = Alignment.Center,
                    contentDescription = teacher.imageUrl
                )
            }
            Text(
                text = teacher.name ?: "Отсутствует ФИО преподавателя",
                modifier = Modifier.padding(start = 5.dp, end = 5.dp, top = 2.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                maxLines = 3
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PostDepDirections(directions: List<DirectionsResponse>?) {
    Column() {
        HeaderInfo("Направления", 60)
        Spacer(Modifier.height(16.dp))
        directions?.forEach { item ->
            var seeMoreAboutDir by remember { mutableStateOf(false) }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 5.dp)
                    .clickable { seeMoreAboutDir = !seeMoreAboutDir },
                elevation = 3.dp,
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ) {
                    Text(
                        text = item.title ?: "Название направления отсутствует",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp)
                    )
                    AnimatedVisibility(visible = seeMoreAboutDir) {
                        Column {
                            item.direction.forEach { dir ->
                                var seeMoreAboutDirection by remember { mutableStateOf(false) }
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(
                                            start = 2.dp,
                                            top = 5.dp,
                                            end = 2.dp,
                                            bottom = 5.dp
                                        )
                                        .clickable {
                                            seeMoreAboutDirection = !seeMoreAboutDirection
                                        },
                                    elevation = 1.dp,
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(5.dp),
                                    ) {

                                        Text(
                                            text = dir.title,
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 18.sp,
                                            color = MaterialTheme.colors.onPrimary,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(start = 5.dp, top = 10.dp, bottom = 10.dp)
                                        )
                                        AnimatedVisibility(visible = seeMoreAboutDirection) {
                                            Column {
                                                Text(
                                                    text = dir.desc,
                                                    color = MaterialTheme.colors.onPrimary,
                                                    fontWeight = FontWeight.Light,
                                                    fontSize = 16.sp,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(
                                                            start = 15.dp,
                                                            top = 10.dp,
                                                            bottom = 10.dp
                                                        )
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        /*}
                        if (seeMoreAboutDir) {*/


                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@ExperimentalCoilApi
@Composable
fun PostDep(department: DepartmentResponse?) {
    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(225.dp),
            shape = RoundedCornerShape(0.dp),
            elevation = 2.dp
        ) {
            val url =
                "https://sun9-82.userapi.com/impg/R5o6T-H47B9w4-3QvIELCGorhdtTdMK83kPS9w/X0VLsXrmOhk.jpg?size=1037x532&quality=96&sign=b4311639578c9f627e4b8b399b71d27c&type=album"
            Image(
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(
                    url
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .height(350.dp),
                alignment = Alignment.Center,
                contentDescription = url
            )
        }
        HeaderInfo("О департаменте", 60)
        var seeMore by remember { mutableStateOf(true) }
        Text(
            text = department?.textInfo ?: "Информация о департаменте отсутствует",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Light,
            maxLines = if (seeMore) 3 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(10.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(top = 15.dp)
                .clickable { seeMore = !seeMore }) {
            Text(
                text = if (seeMore) "Посмотреть больше" else "Скрыть",
                style = MaterialTheme.typography.button,
                color = colorResource(id = R.color.textColorSecondary),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .heightIn(40.dp)
                    .fillMaxWidth()
                    .padding(10.dp)

            )
        }
    }
}

@Composable
fun HeaderInfo(text: String, max_height: Int) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .height(max_height.dp)
            .padding(top = 20.dp, start = 10.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = MaterialTheme.colors.onPrimary
    )
}

@Composable
fun BoxScope.CoastDevelopScreen(
) {
    val coastComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.lotte_dev),
    )

    val progress by animateLottieCompositionAsState(
        composition = coastComposition,
        iterations = LottieConstants.IterateForever
    )

    LottieAnimation(
        composition = coastComposition,
        progress = progress,
        modifier = Modifier
            .align(Alignment.Center)
            .padding(30.dp)
    )
}