package com.asprog.imct.modules.other.ui.screens.onboarding


import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asprog.imct.R
import com.asprog.imct.extensions.sizeLarge
import com.asprog.imct.modules._common.ui.compose.PlugBlock
import com.asprog.imct.modules._common.ui.compose.impl.ClickableTextColorAnimation
import com.asprog.imct.ui.theme.MyTheme

@Composable
fun OnboardingItem2(onNext: () -> Unit = {}) {

    val context = LocalContext.current

    PlugBlock(
        title = stringResource(id = R.string.onboarding_2_title),
        text = stringResource(id = R.string.onboarding_2_text),
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentBoxScope = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    shape = MaterialTheme.shapes.large,
                    colors = ButtonDefaults.textButtonColors(backgroundColor = MaterialTheme.colors.secondary),
                    onClick = onNext,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        color = MaterialTheme.colors.onSecondary,
                        text = stringResource(id = R.string.onboarding_2_btn_permissions),
                    )
                }

                Spacer(modifier = Modifier.sizeLarge())

                ClickableTextColorAnimation(
                    colorDefault = MaterialTheme.colors.onBackground,
                    colorAction = MaterialTheme.colors.onSurface,
                    text = stringResource(id = R.string.onboarding_2_btn_select),
                    underline = true
                ) {
                    Toast.makeText(context, R.string.common_coming_soon, Toast.LENGTH_SHORT).show()
                }

                Spacer(modifier = Modifier.size(6.dp))
            }
        }
    )
}

@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun StartScreen2Preview() {
    MyTheme {
        Scaffold {
            OnboardingItem2()
        }
    }
}