package com.asprog.imct.modules.home.ui.screen.homeScreen.ads

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asprog.imct.R
import com.asprog.imct.modules.home.data.models.HomeAdsModel
import com.asprog.imct.modules.home.ui.events.HomeEvents

@Composable
fun HomeItemAd(
    index: Int = 0,
    model: HomeAdsModel,
    onEvent: (HomeEvents) -> Unit = {},
) {
    val context = LocalContext.current
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(
                    text = model.title,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            },
            text = {
                Text(text = model.description,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal)
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
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(if (index == 0) 318.dp else 300.dp, 140.dp)
            .padding(
                top = 8.dp,
                bottom = 8.dp,
                start = if (index == 0) 16.dp else 0.dp,
                end = 16.dp
            )
    ) {
        Box(
            modifier = Modifier
                .clickable(onClick = {
                    openDialog.value = true
                })
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Text(
                    text = model.title,
                    maxLines = 1,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = model.description,
                    maxLines = 4,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}