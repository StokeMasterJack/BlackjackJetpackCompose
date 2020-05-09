package com.smartsoft.bj.ui

import androidx.compose.Composable
import androidx.ui.material.*


object Theme {
    @Composable
    val colors: ColorPalette
        get() = MaterialTheme.colors

    @Composable
    val c: ColorPalette
        get() = colors

    @Composable
    val typography: Typography
        get() = MaterialTheme.typography

    @Composable
    val t: Typography
        get() = typography

    @Composable
    val emphasis: EmphasisLevels
        get() = EmphasisAmbient.current

    @Composable
    val e: EmphasisLevels
        get() = emphasis

    @Composable
    val shapes: Shapes
        get() = MaterialTheme.shapes

    @Composable
    operator fun component1() = colors

    @Composable
    operator fun component2() = typography

    @Composable
    operator fun component3() = emphasis
}
