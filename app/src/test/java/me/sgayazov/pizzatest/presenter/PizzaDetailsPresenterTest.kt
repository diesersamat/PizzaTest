package me.sgayazov.pizzatest.presenter

import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.Pizza
import org.junit.Test

class PizzaDetailsPresenterTest {

    @Test
    fun addOrRemoveIngredient() {
        val customPizza: Pizza = Pizza()
        customPizza.ingredientObjects = mutableListOf(
                Ingredient(1, "pepper1", 2.2),
                Ingredient(2, "pepper2", 2.2),
                Ingredient(3, "pepper3", 2.2),
                Ingredient(4, "pepper4", 2.2)
        )
    }
}