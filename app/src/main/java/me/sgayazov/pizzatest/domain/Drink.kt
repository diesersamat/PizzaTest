package me.sgayazov.pizzatest.domain

data class Drink(
        val id: Long,
        val name: String,
        val price: Double
) : CartItem