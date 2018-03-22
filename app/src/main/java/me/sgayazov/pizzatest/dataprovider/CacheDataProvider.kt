package me.sgayazov.pizzatest.dataprovider

import io.reactivex.Completable
import io.reactivex.Single
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.PizzaWrapper

class CacheDataProvider: BaseDataProvider {
    override fun makeOrder(cartItemList: List<CartItem>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPizzasList(): Single<PizzaWrapper> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDrinksList(): Single<List<Drink>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIngredientsList(): Single<List<Ingredient>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}