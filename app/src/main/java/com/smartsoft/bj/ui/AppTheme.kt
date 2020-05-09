package com.smartsoft.bj.ui

import androidx.compose.Composable
import androidx.ui.material.*


@Composable
fun ProvideTheme(content: @Composable() () -> Unit) {

    val ssDarkColors = darkColorPalette(
//        primary = Color(red = 20, green = 65,blue = 5)  //#3f51b5
    )

    val ssLiteColors = lightColorPalette(
//        primary = Color(red = 20, green = 65,blue = 5)  //#3f51b5
    )

    fun isDarkMode(): Boolean {
        return false
    }

    fun ssColors(): ColorPalette {
        return if (isDarkMode()) ssDarkColors else ssLiteColors

    }

    val ssTypography: Typography = Typography()

    MaterialTheme(
        colors = ssColors(),
        typography = ssTypography,
        content = content
    )


}