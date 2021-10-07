package com.asprog.imct.modules.other.ui.screens.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.asprog.imct.R
import com.asprog.imct.extensions.sizeLarge
import com.asprog.imct.modules._common.ui.compose.PlugBlock
import com.asprog.imct.ui.theme.MyTheme

@Composable
fun OnboardingItem1(onNext: () -> Unit = {}) {
    PlugBlock(
        title = stringResource(id = R.string.onboarding_1_title),
        text = stringResource(id = R.string.onboarding_1_text),
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentBoxScope = {
            Button(
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.textButtonColors(backgroundColor = MaterialTheme.colors.secondary),
                onClick = onNext,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    color = MaterialTheme.colors.onSecondary,
                    text = stringResource(id = R.string.onboarding_1_btn),
                )
            }

            Spacer(modifier = Modifier.sizeLarge())
        }
    )
}

@ExperimentalComposeUiApi
@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun StartScreen1Preview() {
    MyTheme {
        Scaffold {
            OnboardingItem1()
        }
    }
}