package com.asprog.imct.modules.home.navigation.nav.impl

import com.asprog.imct.base.NavScreenWithArgument4

object NewsNavScreen {

    val NewsScreen = object : NavScreenWithArgument4 {
        override val routeWithArgument: String =
            "SingleNewsScreen/title={title}&description={description}&images={images}&author={author}"
        override val argument0: String = "title"
        override val argument1: String = "description"
        override val argument2: String = ""
        override val argument3: String = "author"
    }

}