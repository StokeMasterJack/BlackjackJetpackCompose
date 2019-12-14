package com.smartsoft.bj

class Hand private constructor(val name: String, val cards: List<Card>) {

    constructor(name: String) : this(name, emptyList())

    fun addCard(card: Card): Hand {
        return Hand(name, cards + card)
    }

    fun addCards(cards: List<Card>): Hand {
        return Hand(name, this.cards + cards)
    }

    fun init(cards: List<Card> = emptyList()): Hand = Hand(name, cards)

    val size
        get() = cards.size

    val points get() = cards.sumBy { it.points }

    val msg: String
        get() {
            val p = this.points
            if (p > 21) return "$p Points. Bust!"
            if (p == 21) return "Black Jack!"
            return "$p Points."
        }

    fun dump() {
        println("$name  Hand")
        cards.forEach {
            println(it.name)
        }
        println("$points  points")
    }
}