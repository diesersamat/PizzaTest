package me.sgayazov.pizzatest.domain

class Pizza(
        val name: String,
        val ingredients: List<Long>,
        val imageUrl: String
) : CartItem