package me.sgayazov.pizzatest.dataprovider

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import io.reactivex.Completable
import io.reactivex.Single
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.domain.Order
import me.sgayazov.pizzatest.domain.Pizza
import me.sgayazov.pizzatest.persistence.CartDao
import javax.inject.Inject

class CacheDataProvider @Inject constructor(application: Application) {

    @Database(entities = [(Order::class)], version = 1)
    abstract inner class AppDatabase : RoomDatabase() {
        abstract fun cartDao(): CartDao
    }

    private var db = Room.databaseBuilder(application,
            AppDatabase::class.java, "pizza-db").build()

    fun getCartItems(): Single<List<CartItem>> {
        db.cartDao().all
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