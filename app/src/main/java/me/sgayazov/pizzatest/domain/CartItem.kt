package me.sgayazov.pizzatest.domain

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cart")
class CartItem(
        @PrimaryKey
        val id: String,
        val name: String,
        val ingredientsString: String,
        val price: Double,
        val isPizza: Boolean
)