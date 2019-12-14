package com.smartsoft.bj;

import com.smartsoft.util.shuffledIf

data class DeckCard(val deck: Deck, val card: Card)
data class DeckCards(val deck: Deck, val cards: List<Card>)

/**
 * nextCard=52 means deck is empty
 */
class Deck private constructor(val cards: List<Card>, val nextCard: Int, val shuffle: Boolean = true) {

    init {
        require(cards.size == 52)
        require(nextCard in 0..52)
    }

    constructor(shuffle: Boolean = true) : this(cards = createCardList(shuffle), nextCard = 0, shuffle = shuffle)

    private fun cp(cards: List<Card> = this.cards, nextCard: Int = this.nextCard, shuffle: Boolean = this.shuffle) = Deck(cards, nextCard, shuffle)

    val size
        get() = 52 - nextCard

    val isEmpty: Boolean get() = nextCard == 52

    fun takeCard(): DeckCard = takeCards(1).let {
        check(it.cards.size == 1)
        DeckCard(it.deck, it.cards[0])
    }

    fun takeCards(n: Int): DeckCards = DeckCards(cp(nextCard = this.nextCard + n), cards.subList(this.nextCard, this.nextCard + n))

    fun maybeReset(min: Int): Deck = if (size < min) reset() else this

    private fun reset(): Deck = Deck(shuffle = shuffle)

    companion object {
        private fun createCardList(shuffle: Boolean): List<Card> = (0..51).map { Card(it) }.shuffledIf(shuffle)
    }

    fun dump() {
        println("nextCard: $nextCard")
        cards.forEach { println(it.name) }
    }


}
