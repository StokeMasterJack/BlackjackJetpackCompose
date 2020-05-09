package com.smartsoft.bj.ui

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.smartsoft.bj.core.BjDispatch
import com.smartsoft.bj.core.Game
import com.smartsoft.bj.core.Hand

@Composable
fun Blackjack2() = Blackjack @Composable() { g, d -> BlackjackVu2(g, d) }

@Composable
private fun BlackjackVu2(game: Game = Game.mk(false), dispatch: BjDispatch = {}) {
    Surface(color = Color.Transparent) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            ButtonsVu(game, dispatch)
            HandsVu2(game)
            GameMsgVu(game.msg)
        }
    }
}

@Composable
private fun HandsVu2(game: Game) {
//    val surfaceColor  = Color.Transparent
    val surfaceColor = Color.Yellow
    Surface(color = surfaceColor) {
        Row(
            modifier = Modifier.fillMaxWidth().heightIn(minHeight = 270.dp, maxHeight = 270.dp),
            horizontalArrangement = Arrangement.Center,
            verticalGravity = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier.weight(1f).padding(
                    start = 18.dp,
                    end = 9.dp,
                    top = 10.dp,
                    bottom = 10.dp
                )
            ) {
                HandVu2(hand = game.ph)
            }
            Column(
                modifier = Modifier.weight(1f).padding(
                    start = 9.dp,
                    end = 18.dp,
                    top = 10.dp,
                    bottom = 10.dp
                )

            ) {
                HandVu2(hand = game.dh)
            }
        }
    }
}

@Composable
private fun HandVu2(hand: Hand) {
    val (c, t) = Theme
    val tColor = c.primaryVariant
    val tStyle = t.subtitle1.copy(color = tColor, fontWeight = FontWeight.Bold)


//    val surfaceColor = c.secondary.copy(alpha = .1f)
    val surfaceColor = Color.Red
    Surface(color = surfaceColor) {
        Column(
            modifier = Modifier.fillMaxWidth().heightIn(minHeight = 100.dp, maxHeight = 100.dp),
//            modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalGravity = Alignment.Start
        ) {

            Text(text = "${hand.name} Hand", style = tStyle)

            Column(modifier = Modifier.weight(1f)) {
                hand.cards.forEach {
                    Text(text = it.name)
                }
            }

            Text(text = hand.msg, style = tStyle)
        }
    }
}

@Preview
@Composable
private fun BlackjackPreview2() {
    MaterialTheme {
        BlackjackVu2()
    }
}
