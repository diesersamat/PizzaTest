package me.sgayazov.pizzatest.dataprovider

import io.reactivex.Completable
import io.reactivex.Single
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.PizzaWrapper

interface BaseDataProvider {
    fun getPizzasList(): Single<PizzaWrapper>

    fun getDrinksList(): Single<List<Drink>>

    fun getIngredientsList(): Single<List<Ingredient>>

    fun makeOrder(cartItemList: List<CartItem>): Completable
}