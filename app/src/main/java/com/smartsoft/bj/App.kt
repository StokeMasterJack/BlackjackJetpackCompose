package com.smartsoft.bj

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus

@Composable
fun App() {
    val (page, nav) = +state { Page.Home }

    when (page) {
        Page.Home -> Home(nav)
        Page.GameText -> GameText()
        Page.GameGraphic -> GameText()
    }
}
