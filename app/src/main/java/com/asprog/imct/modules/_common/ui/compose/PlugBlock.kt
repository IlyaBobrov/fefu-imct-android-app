package com.asprog.imct.modules._common.ui.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asprog.imct.R
import com.asprog.imct.extensions.sizeLarge
import com.asprog.imct.extensions.sizeMedium
import com.asprog.imct.extensions.sizeXLarge
import com.asprog.imct.ui.theme.MaterialThemeCustom
import com.asprog.imct.ui.theme.MyTheme

@Composable
fun PlugBlock(
    title: String? = null,
    text: String? = null,
    painter: Painter = painterResource(id = R.drawable.ic_launcher_foreground),
    contentBoxScope: @Composable BoxScope.() -> Unit = {},
    contentColumnScope: @Composable ColumnScope.() -> Unit = {},
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .size(248.dp)
                        .align(Alignment.Center)
                ) {
                    Image(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        painter = painter,
                        contentDescription = null)
                }
            }

            title?.let {
                Spacer(modifier = Modifier.sizeXLarge())

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = title.uppercase(),
                    style = MaterialTheme.typography.h5,
                )
            } ?: run {
                Spacer(modifier = Modifier.sizeLarge())
            }

            text?.let {
                Spacer(modifier = Modifier.sizeMedium())

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MaterialThemeCustom.colors.textColorSecondary,
                    text = text,
                    style = MaterialTheme.typography.subtitle1,
                )
            }

            contentColumnScope.invoke(this)
        }

        contentBoxScope.invoke(this)
    }
}

@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PlugBlockPreview() {
    MyTheme {
        Scaffold {
            PlugBlock(
                title = "Title",
                text = "Long text for preview",
            )
        }
    }
}