package me.sgayazov.pizzatest.domain

interface CartItem {
    val name: String
    fun finalPrice(): Double
}