package me.sgayazov.pizzatest.utils

class Utils {
    companion object {
        fun formatPrice(basePrice: Double): String {
            return "$ $basePrice"
        }
    }
}