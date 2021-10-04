package com.asprog.imct.modules.home.ui.events

sealed class HomeEvents {
    object NavigateBack : HomeEvents()
    object RefreshHome : HomeEvents()
    object NavigateToNews : HomeEvents()
    data class NewsSingleData(val title: String) : HomeEvents()
    data class NavigateToNewsWithArg(
        val title: String,
        val description: String,
        val image: String,
        val author: String
    ) : HomeEvents()
}