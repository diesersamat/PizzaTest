package me.sgayazov.pizzatest.domain

import android.arch.persistence.room.Entity

@Entity
data class Drink(
        val id: Long,
        override val name: String,
        val price: Double
) : CartItem {
    override fun finalPrice(): Double = price
}