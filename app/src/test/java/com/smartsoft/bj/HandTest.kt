package com.smartsoft.bj

import org.junit.Assert.assertEquals
import org.junit.Test

class HandTest {

    @Test
    fun testHand() {
        Hand(name = "Player")
                .addCard(Card(value = 1, suit = 1))
                .addCard(Card(value = 13, suit = 4))
                .apply {
                    assertEquals("Player", name)
                    assertEquals(11, points)
                    assertEquals(2, size)
                }

        Hand("Dealer")
                .addCards(listOf(
                        Card(value = 1, suit = 1),
                        Card(value = 2, suit = 1),
                        Card(value = 3, suit = 1))
                ).apply {

                    assertEquals("Dealer", name)
                    assertEquals(6, points)
                    assertEquals(3, size)
                }


    }


}

