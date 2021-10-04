package com.asprog.imct.modules.profile.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asprog.imct.modules.profile.ui.event.ProfileEvents
import com.asprog.imct.R
import com.asprog.imct.extensions.sizeLarge
import com.asprog.imct.extensions.sizeXLarge
import com.asprog.imct.ui.theme.MaterialThemeCustom
import com.asprog.imct.ui.theme.MyTheme


@Composable
fun ProfileLoginBody(
    onEvent: (ProfileEvents) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .padding(top = 24.dp, bottom = 24.dp, start = 16.dp, end = 16.dp)
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.profile_login_title),
            style = MaterialTheme.typography.h5,
        )

        Spacer(modifier = Modifier.sizeLarge())

        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = MaterialThemeCustom.colors.textColorSecondary,
            text = stringResource(id = R.string.profile_login_text),
            style = MaterialTheme.typography.subtitle1,
        )

        Spacer(modifier = Modifier.sizeXLarge())

        Button(
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.textButtonColors(backgroundColor = MaterialTheme.colors.secondary),
            onClick = {
                onEvent(ProfileEvents.NavigateToSignIn)
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                color = MaterialTheme.colors.onSecondary,
                text = stringResource(id = R.string.profile_login_btn_login),
            )
        }

        Spacer(modifier = Modifier.sizeLarge())

        OutlinedButton(
            shape = MaterialTheme.shapes.large,
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                color = MaterialTheme.colors.onPrimary,
                text = stringResource(id = R.string.profile_login_btn_registration),
            )
        }
    }
}

@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfileLoginBodyPreview() {
    MyTheme {
        Surface {
            ProfileLoginBody()
        }
    }
}