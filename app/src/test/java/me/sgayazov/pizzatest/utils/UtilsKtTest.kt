package me.sgayazov.pizzatest.utils

import org.junit.Test

class UtilsKtTest {

    @Test
    fun formatPrice_Empty() {
        val price = formatPrice()
        assert(price == "$ 0")
    }

    @Test
    fun formatPrice_Zero() {
        val price = formatPrice(0.0)
        assert(price == "$ 0")
    }

    @Test
    fun formatPrice_Normal_Integer() {
        val price = formatPrice(56.0)
        assert(price == "$ 56")
    }

    @Test
    fun formatPrice_Normal_Double_One() {
        val price = formatPrice(56.5)
        assert(price == "$ 56.50")
    }

    @Test
    fun formatPrice_Normal_Double_Two() {
        val price = formatPrice(56.54)
        assert(price == "$ 56.54")
    }
}