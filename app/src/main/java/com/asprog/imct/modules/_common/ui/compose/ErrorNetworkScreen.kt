package com.asprog.imct.modules._common.ui.compose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.asprog.imct.base.LocalBaseViewModel
import com.asprog.imct.extensions.sizeSmall
import com.asprog.imct.extensions.sizeXLarge
import com.asprog.imct.ui.theme.MyTheme
import com.asprog.imct.R


@Composable
fun ErrorNetworkScreen(
    loading: Boolean = false
) {
    val baseViewModel = LocalBaseViewModel.current

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        PlugBlock(
            title = stringResource(id = R.string.common_error_network_title),
            text = stringResource(id = R.string.common_error_network_text),
            painter = painterResource(id = R.drawable.ic_common_warning_network)
        ) {

            if (loading) {
                Spacer(modifier = Modifier.sizeSmall())
                Loader()
            } else {
                Spacer(modifier = Modifier.sizeXLarge())

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    OutlinedButton(
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier.align(Alignment.Center),
                        onClick = {
                            baseViewModel.listRefresh()
                        },
                    ) {
                        Text(
                            color = MaterialTheme.colors.onPrimary,
                            text = stringResource(id = R.string.common_error_network_btn),
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ErrorNetworkScreenPreview() {
    MyTheme {
        Scaffold {
            ErrorNetworkScreen()
        }
    }
}