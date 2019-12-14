package com.smartsoft.bj;

//  value = (index % 13) + 1, suit = (index / 13) + 1

data class Card(val index: Int) {

    init {
        require(index in 0..51) { "Bad card index $index" }
    }

    constructor(value: Int, suit: Int) : this(computeIndex(value, suit))

    val suit: Int get() = (index / 13) + 1
    val value: Int get() = (index % 13) + 1

    val suitName: String
        get() = when (suit) {
            1 -> "Spades"
            2 -> "Hearts"
            3 -> "Clubs"
            4 -> "Diamonds"
            else -> throw IllegalStateException()
        }

    /*
    val valueName: String
        get() = when (value) {
            1 -> "Ace"
            in 2..10 -> value.toString()
            11 -> "Jack"
            12 -> "Queen"
            13 -> "King"
            else -> throw IllegalStateException()
        }
    */

    val valueName: String
        get() = when {
            value == 1 -> "Ace"
            value in 2..10 -> value.toString()
            value == 11 -> "Jack"
            value == 12 -> "Queen"
            value == 13 -> "King"
            else -> throw IllegalStateException()
        }

    val name: String get() = "$valueName of $suitName"

//    val points: Int
//        get() = when (value) {
//            in 1..9 -> value
//            in 10..13 -> 10
//            else -> throw IllegalStateException()
//        }

//    val index: Int get() = (suit - 1) * 13 + (value - 1)

    val points
        get() = when {
            value in 1..9 -> value
            value in 10..13 -> 10
            else -> throw IllegalStateException()
        }

    companion object {
        fun computeIndex(value: Int, suit: Int): Int {
            require(value in 1..13) { "Invalid card value: $value" }
            require(suit in 1..4) { "Invalid card suit: $suit" }
            return (suit - 1) * 13 + (value - 1)
        }
    }

    override fun toString(): String {
        return name
    }


    fun dump() {
        println(this)
    }

    override fun equals(other: Any?) = other is Card && other.index == index

    override fun hashCode() = index

}


fun main(args: Array<String>) {
    for (i in 0..51) {
        println(Card(i).name)
    }


}