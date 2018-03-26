package me.sgayazov.pizzatest.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single
import me.sgayazov.pizzatest.domain.CartItem


@Dao
interface CartDao {

    @get:Query("SELECT * FROM cart")
    val all: Single<List<CartItem>>

    @Insert
    fun insertAll(vararg cartItem: CartItem)

    @Delete
    fun delete(cartItem: CartItem)

    @Query("DELETE FROM cart")
    fun deleteAll()
}