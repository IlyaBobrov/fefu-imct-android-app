package com.asprog.imct.modules._common.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.asprog.imct.modules._common.ui.compose.impl.FieldState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScaffoldSearch(
    modifier: Modifier = Modifier,
    contentTitle: @Composable (() -> Unit)? = null,
    contentLoad: @Composable (() -> Unit)? = null,
    contentLoadState: Boolean = false,
    navigationIcon: ImageVector? = null,
    navigationIconDescription: String = "Navigate up",
    navigationIconOnClick: () -> Unit = {},
    searchIcon: ImageVector = Icons.Default.Search,
    searchIconDescription: String = "Search",
    searchListener: ((String?) -> Unit)? = null,
    closeSearchListener: (() -> Unit)? = null,
    searchTextColor: Color = MaterialTheme.colors.onPrimary,
    topBarIconColor: Color = MaterialTheme.colors.onPrimary,
    topBarBackgroundColor: Color = MaterialTheme.colors.primary,
    searchDescription: String = "Search...",
    topBarElevation: Dp = AppBarDefaults.TopAppBarElevation,
    actions: @Composable ((RowScope) -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit,
) {

    val softwareKeyboardController = LocalSoftwareKeyboardController.current
    var isShowSearch by remember { mutableStateOf(false) }
    val state = remember { FieldState() }
    val requester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = modifier,
        topBar = contentTitle?.let {
            {
                TopAppBar(
                    backgroundColor = topBarBackgroundColor,
                    elevation = topBarElevation,
                    title = {
                        Box {
                            searchListener?.let {
                                if (isShowSearch) {
                                    if (state.getValue().isEmpty()) {
                                        Text(
                                            fontSize = TextUnit.Unspecified,
                                            text = searchDescription,
                                            color = searchTextColor
                                        )
                                    }
                                    BasicTextField(
                                        singleLine = true,
                                        value = state.text,
                                        onValueChange = { state.text = it },
                                        modifier = Modifier
                                            .focusRequester(requester)
                                            .fillMaxWidth()
                                            .onFocusChanged { focusState ->
                                                if (focusState.isFocused) {
                                                    state.positionToEnd()
                                                }
                                            },
                                        textStyle = MaterialTheme.typography.h5.merge(TextStyle(color = searchTextColor)),
                                        keyboardOptions = KeyboardOptions.Default.copy(
                                            capitalization = KeyboardCapitalization.Sentences,
                                            imeAction = ImeAction.Search
                                        ),
                                        keyboardActions = KeyboardActions(onSearch = {
                                            focusManager.clearFocus()
                                            searchListener(state.getValue())
                                            softwareKeyboardController?.hide()
                                        }),
                                        cursorBrush = SolidColor(searchTextColor)
                                    )
                                    LaunchedEffect(isShowSearch) {
                                        requester.requestFocus()
                                    }
                                } else {
                                    contentTitle.invoke()
                                }
                            } ?: run {
                                Column(
                                    modifier = Modifier
                                        .padding(end = if (navigationIcon == null) 12.dp else 0.dp)
                                        .fillMaxWidth(),
                                ) {
                                    contentTitle.invoke()
                                }
                            }
                        }
                    },
                    navigationIcon = navigationIcon?.let {
                        {
                            IconButton(onClick = navigationIconOnClick) {
                                Icon(
                                    imageVector = navigationIcon,
                                    contentDescription = navigationIconDescription,
                                    tint = topBarIconColor
                                )
                            }
                        }
                    },
                    actions = {
                        searchListener?.let {
                            IconButton(onClick = {
                                state.clear()
                                isShowSearch = !isShowSearch
                                if (!isShowSearch) {
                                    searchListener(null)
                                    softwareKeyboardController?.hide()
                                    requester.freeFocus()
                                    closeSearchListener?.invoke()
                                }
                            }) {
                                if (isShowSearch) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = searchIconDescription,
                                        tint = topBarIconColor
                                    )
                                } else {
                                    Icon(
                                        imageVector = searchIcon,
                                        contentDescription = searchIconDescription,
                                        tint = topBarIconColor
                                    )
                                }
                            }
                        }

                        actions?.invoke(this)

                        if (contentLoadState) {
                            contentLoad?.invoke() ?: run {
                                Box(
                                    modifier = Modifier.size(48.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator(
                                        strokeWidth = 2.dp,
                                        color = topBarIconColor,
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                }
                            }
                        }
                    }
                )
            }
        } ?: {},
        content = {
            content.invoke(it)
        },
    )
}