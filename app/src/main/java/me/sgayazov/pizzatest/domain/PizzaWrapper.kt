package me.sgayazov.pizzatest.domain

data class PizzaWrapper(
        val basePrice: Double,
        val pizzas: List<Pizza>
)