package me.sgayazov.pizzatest.dataprovider

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import me.sgayazov.pizzatest.domain.*

class Interactor(private val cacheDataProvider: CacheDataProvider,
                 private val networkDataProvider: NetworkDataProvider) {

    fun getPizzasList(): Single<List<Pizza>> {
        return Single.zip<PizzaWrapper, List<Ingredient>, List<Pizza>>(networkDataProvider.getPizzasList(),
                networkDataProvider.getIngredientsList(), BiFunction { pizzaWrapper, ingredientsList ->
            val pizzaList = pizzaWrapper.pizzas
            pizzaList.forEach({ pizza ->
                pizza.ingredientObjects = mutableListOf()
                pizza.basePrice = pizzaWrapper.basePrice
                pizza.ingredients.forEach({ ingredientId ->
                    ingredientsList.find { ingredient -> ingredient.id == ingredientId }?.let { pizza.ingredientObjects.add(it) }
                })
            })
            return@BiFunction pizzaList
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getIngredientsList(): Single<List<Ingredient>> {
        return networkDataProvider.getIngredientsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getDrinksList(): Single<List<Drink>> {
        return networkDataProvider.getDrinksList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun makeOrder(): Single<Any> {
        return getCartItems().flatMap { networkDataProvider.makeOrder(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun addPizzaToCart(pizza: Pizza): Completable {
        return cacheDataProvider.addPizzaToCart(pizza)
    }


    fun addDrinkToCart(drink: Drink): Completable {
        return cacheDataProvider.addDrinkToCart(drink)
    }

    fun getCartItems(): Single<List<CartItem>> {
        return cacheDataProvider.getCartItems()
    }

    fun removeCartItem(cartItem: CartItem): Single<List<CartItem>> {
        return cacheDataProvider.removeCartItem(cartItem).andThen(cacheDataProvider.getCartItems())
    }
}
