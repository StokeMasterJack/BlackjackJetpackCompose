package com.smartsoft.bj.ui

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Row
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import com.smartsoft.bj.core.BjAction
import com.smartsoft.bj.core.BjDispatch
import com.smartsoft.bj.core.Game
import com.smartsoft.util.VF
import java.util.*


typealias BlackjackVu = @Composable() (game: Game, dispatch: BjDispatch) -> Unit


@Composable
fun Blackjack(vu: BlackjackVu) {

    val (game, setGame) = state { Game.mk() }

    fun reducer(g1: Game, action: BjAction): Game = when (action) {
        BjAction.Deal -> g1.deal()
        BjAction.Hit -> g1.hit()
        BjAction.Stay -> g1.stay()
    }

    fun dispatch(action: BjAction) {
        val g2 = reducer(game, action)
        setGame(g2)
        //modelView.game.value = g2
    }

    MaterialTheme {
        vu(game, ::dispatch)
    }
}


@Composable
fun GameMsgVu(msg: String) {
    val (c, t) = Theme
    val tColor = c.secondaryVariant
    val tStyle = t.h5.copy(
        color = tColor,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold
    )
    Surface(color = Color.Transparent) {
        Row(
            verticalGravity = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().padding(
                top = 20.dp,
                bottom = 20.dp
            )
        ) {
            Text(text = msg, style = tStyle)
        }
    }
}

@Composable
fun ButtonsVu(game: Game, dispatch: BjDispatch) {

    val (c, t) = Theme

    val deal = { dispatch(BjAction.Deal) }
    val hit = { dispatch(BjAction.Hit) }
    val stay = { dispatch(BjAction.Stay) }

    val d: VF = deal
    val h: VF = hit
    val s: VF = stay

    val dEnabled: Boolean = game.isGameOver
    val hEnabled: Boolean = !game.isGameOver
    val sEnabled: Boolean = !game.isGameOver

//    val surfaceColor = Color.Green
//    val surfaceColor = Color.Transparent
    val surfaceColor = c.surface
//    Surface(color = surfaceColor) {
    Row(
        verticalGravity = Alignment.Top,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().padding(
            top = 20.dp,
            bottom = 20.dp
        )
    ) {
        Btn(
            BjAction.Deal,
            onClick = d,
            enabled = dEnabled
        )
        Btn(
            BjAction.Hit,
            onClick = h,
            enabled = hEnabled
        )
        Btn(
            BjAction.Stay,
            onClick = s,
            enabled = sEnabled
        )
//        }
    }
}

@Composable
fun Btn(action: BjAction, enabled: Boolean, onClick: VF) {
    val (c, t) = Theme
    val tColor = if (enabled) {
        c.background
    } else {
        Color(137, 137, 137)
    }

    val bColor = if (enabled) {
        c.primary
    } else {
        Color(220, 220, 220)
    }

    val bEl = if (enabled) {
        2.dp
    } else {
        0.dp
    }


    val tStyle = t.body2.copy(color = tColor)



    Button(
        backgroundColor = bColor,
        elevation = bEl,
        enabled = enabled,
        modifier = Modifier.padding(
            10.dp
        ), onClick = onClick
    ) {
        Text(
            text = action.name.toUpperCase(Locale.ROOT),
            style = tStyle
        )
    }
}