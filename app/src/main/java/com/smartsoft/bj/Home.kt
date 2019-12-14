package com.smartsoft.bj

import androidx.compose.Composable
import androidx.ui.core.dp
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

@Composable
fun Home(nav: Nav) {
    Row(modifier = Expanded,arrangement = Arrangement.Center){
        Column( modifier = ExpandedHeight.wraps(Spacing(8.dp)),arrangement = Arrangement.Center) {
            Button(text = "Play Game - UI 1", modifier = Spacing(8.dp), onClick = { nav(Page.GameText) })
            Button(text = "Play Game - UI 2", modifier = Spacing(8.dp), onClick = { nav(Page.GameGraphic) })
        }

    }

}


@Preview
@Composable
private fun HomePreview() {
    MaterialTheme {
        Home {}
    }
}
