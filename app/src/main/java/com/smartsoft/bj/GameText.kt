package com.smartsoft.bj

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.ButtonStyle
import androidx.ui.material.ContainedButtonStyle
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview

val bg = Color(0xFF,0xFA,0xFA)
@Composable
fun GameText() {

    val (game, setGame) = +state { Game().deal() }

    fun reducer(g1: Game, action: BjAction) = when (action) {
        BjAction.Deal -> g1.deal()
        BjAction.Hit -> g1.hit()
        BjAction.Stay -> g1.stay()
    }

    fun dispatch(action: BjAction) {
        val g2 = reducer(game, action)
        setGame(g2)
    }

    MaterialTheme {
        GameTextVu(game, ::dispatch)
    }
}


@Composable
fun GameTextVu(game: Game, dispatch: BjDispatch) {
    val c1 = (+MaterialTheme.colors()).surface
    Surface(color = Color.Transparent) {
        Column(
            modifier = Expanded,
            arrangement = Arrangement.Begin
        ) {
            GameButtonsVu(game, dispatch)
            HandsVu(game)
            GameMsgVu(game.msg)
        }
    }
}

@Composable
fun HandsVu(game: Game) {
    val colors = +MaterialTheme.colors()
    Surface(color = Color.Transparent) {
        Row(
            modifier = ExpandedWidth.wraps(MaxHeight(230.dp)).wraps(MinHeight(230.dp)),
            arrangement = Arrangement.Center
        ) {
            Column(
                modifier = Flexible(1f).wraps(
                    Spacing(
                        left = 18.dp,
                        right = 9.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                )
            ) {
                HandVu(hand = game.ph)
            }
            Column(
                modifier = Flexible(1f).wraps(
                    Spacing(
                        left = 9.dp,
                        right = 18.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                )
            ) {
                HandVu(hand = game.dh)
            }
        }
    }
}

@Composable
fun HandVu(hand: Hand) {
    val colors = +MaterialTheme.colors()
    val tColor = colors.primaryVariant
    val tStyle =
        (+MaterialTheme.typography()).subtitle1.copy(color = tColor, fontWeight = FontWeight.Bold)

    Surface(color = colors.secondary.copy(alpha = .2f)) {
        Column(modifier = Expanded.wraps(Spacing(10.dp))) {
            Text(text = "${hand.name} Hand", style = tStyle)
            Column(modifier = Flexible(1f)) {
                hand.cards.forEach {
                    Text(text = it.name)
                }
            }


            Text(text = hand.msg, style = tStyle)
        }
    }
}


@Composable
fun GameButtonsVu(game: Game, dispatch: BjDispatch) {

    val colors = +MaterialTheme.colors()
    val deal = { dispatch(BjAction.Deal) }
    val hit = { dispatch(BjAction.Hit) }
    val stay = { dispatch(BjAction.Stay) }

    val d: VF? = if (game.isGameOver) deal else null
    val h: VF? = if (game.isGameOver) null else hit
    val s: VF? = if (game.isGameOver) null else stay

    Surface(color = Color.Transparent) {
        Row(
            arrangement = Arrangement.Center,
            modifier = ExpandedWidth.wraps(Spacing(top = 20.dp, bottom = 20.dp))
        ) {
            Btn(BjAction.Deal, onClick = d)
            Btn(BjAction.Hit, onClick = h)
            Btn(BjAction.Stay, onClick = s)
        }
    }
}

@Composable
fun GameMsgVu(msg: String) {
    val colors = +MaterialTheme.colors()
    val tColor = colors.secondaryVariant
    val tStyle = (+MaterialTheme.typography()).h5.copy(
        color = tColor,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold
    )
    Surface(color = Color.Transparent) {
        Row(
            arrangement = Arrangement.Center,
            modifier = ExpandedWidth.wraps(Spacing(top = 20.dp, bottom = 20.dp))
        ) {
            Text(text = msg, style = tStyle)
        }
    }
}

@Composable
fun Btn(action: BjAction, onClick: VF?) {

    val colors = +MaterialTheme.colors()
    val tColor = if (onClick != null) {
        colors.background
    } else {
        Color(137, 137, 137)
    }

    val bColor = if (onClick != null) {
        colors.primary
    } else {
        Color(220, 220, 220)
    }

    val bEl = if (onClick != null) {
        2.dp
    } else {
        0.dp
    }


    val tStyle = (+MaterialTheme.typography()).body2.copy(color = tColor)
    val bStyle: ButtonStyle = ContainedButtonStyle(color = bColor, elevation = bEl)


    Button(modifier = Spacing(10.dp), onClick = onClick, style = bStyle) {
        Text(text = action.name.toUpperCase(), style = tStyle)
    }
}

@Preview
@Composable
fun GameTextPreview() {
    MaterialTheme {
        GameTextVu(Game().deal()) {}
    }
}
