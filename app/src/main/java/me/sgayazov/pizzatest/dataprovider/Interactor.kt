package me.sgayazov.pizzatest.dataprovider

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.Pizza

class Interactor(private val cacheDataProvider: CacheDataProvider,
                 private val networkDataProvider: NetworkDataProvider) {

    fun getPizzasList(): Single<List<Pizza>> {
//        return Observable.zip(networkDataProvider.getPizzasList(),
//                getIngredientsList(), )
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())

        networkDataProvider.getPizzasList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t1, t2 ->
                    var i = 0
                    i++
                }

        return Single.just(listOf())
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

    fun makeOrder(cartItems: List<CartItem>): Completable {
        return networkDataProvider.makeOrder(cartItems)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
