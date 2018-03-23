package me.sgayazov.pizzatest.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(tableName = "cart")
class Order(
        @ColumnInfo(name = "pizzas")
        val pizzas: List<Pizza>,
        @ColumnInfo(name = "drinks")
        val drinks: List<Int>
)