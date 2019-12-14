package com.smartsoft.bj;

private const val ReshuffleLimit = 30

class Game private constructor(val deck: Deck, val ph: Hand, val dh: Hand, val isStay: Boolean) {

    constructor(shuffle: Boolean = true) : this(deck = Deck(shuffle), ph = Hand("Player"), dh = Hand("Dealer"), isStay = false)

    private fun cp(deck: Deck = this.deck, ph: Hand = this.ph, dh: Hand = this.dh, isStay: Boolean = this.isStay) = Game(deck, ph, dh, isStay)

    fun hit(): Game {
        return if (!isGameOver) {
            val (deck, card) = deck.takeCard()
            cp(deck = deck, ph = ph.addCard(card))
        } else {
            this
        }
    }

    fun stay(): Game {
        return if (!isGameOver) {
            var deck = deck
            var dh = dh
            while (dh.points < 17) {
                val (d, card) = deck.takeCard()
                deck = d
                dh = dh.addCard(card)
            }
            cp(deck = deck, dh = dh, isStay = true)
        } else {
            this
        }
    }

    fun deal(): Game {
        val (deck, cards) = deck.maybeReset(ReshuffleLimit).takeCards(4)
        val ph = ph.init(cards.slice(0..1))
        val dh = dh.init(cards.slice(2..3))
        return cp(deck = deck, ph = ph, dh = dh, isStay = false)
    }

    val isGameOver: Boolean get() = isStay || ph.points >= 21

    val msg: String
        get() = if (isGameOver) {
            when {
                ph.points > 21 -> "Dealer Wins!"
                dh.points > 21 -> "Player Wins!"
                ph.points == dh.points -> "Tie"
                ph.points > dh.points -> "Player Wins!"
                dh.points > ph.points -> "Dealer Wins!"
                else -> throw IllegalStateException()
            }
        } else {
            "Press Hit or Stay"
        }



}