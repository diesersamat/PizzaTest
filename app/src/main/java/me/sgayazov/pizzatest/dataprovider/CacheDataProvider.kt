package me.sgayazov.pizzatest.dataprovider

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import io.reactivex.Completable
import io.reactivex.Single
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.domain.Pizza
import me.sgayazov.pizzatest.persistence.CartDao
import javax.inject.Inject

@Database(entities = [(CartItem::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}

class CacheDataProvider @Inject constructor(application: Application) {

    private var db = Room.databaseBuilder(application,
            AppDatabase::class.java, "pizza-db").build()

    fun getCartItems(): Single<List<CartItem>> {
        return db.cartDao().all
    }

    fun removeCartItem(cartItem: CartItem): Completable {
        return Completable.fromAction { db.cartDao().delete(cartItem) }
    }

    fun addDrinkToCart(drink: Drink): Completable {
        val cartItem = CartItem(drink.name + drink.price, drink.name, "", drink.price, false)
        return Completable.fromAction { db.cartDao().insertAll(cartItem) }
    }

    fun addPizzaToCart(pizza: Pizza): Completable {
        val cartItem = CartItem(pizza.name + pizza.finalPrice() + pizza.ingredientsToString(),
                pizza.name, pizza.ingredientsToString(),
                pizza.finalPrice(), true)
        return Completable.fromAction { db.cartDao().insertAll(cartItem) }
    }

    fun clearCart(): Completable {
        return Completable.fromAction { db.cartDao().deleteAll() }
    }
}