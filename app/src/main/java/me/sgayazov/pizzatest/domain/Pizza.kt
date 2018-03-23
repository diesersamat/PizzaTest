package me.sgayazov.pizzatest.domain

class Pizza(
        val name: String,
        val ingredients: List<Long>,
        val imageUrl: String?
) : CartItem {
    var basePrice: Double = 0.0
    var ingredientObjects = mutableListOf<Ingredient>()

    fun sumOfIngredients(): Double {
        val sumOfIngredients = 0.0
        ingredientObjects.forEach({ ingredient -> sumOfIngredients + ingredient.price })
        return sumOfIngredients
    }

    fun ingredientsToString(): String = ingredientObjects.joinToString { it.name }
}