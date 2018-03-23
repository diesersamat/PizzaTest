package me.sgayazov.pizzatest.dataprovider

import io.reactivex.Completable
import io.reactivex.Single
import me.sgayazov.pizzatest.domain.*

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

    fun getCartItems(): Single<List<CartItem>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun removeCartItem(cartItem: CartItem): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun addDrinkToCart(drink: Drink): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun addPizzaToCart(pizza: Pizza): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}