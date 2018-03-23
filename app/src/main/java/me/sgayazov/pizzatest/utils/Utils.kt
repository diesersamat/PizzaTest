package me.sgayazov.pizzatest.utils

class Utils {
    companion object {
        fun formatPrice(number: Double = 0.0): String {
            val epsilon = 0.004f
            return if (Math.abs(Math.round(number) - number) < epsilon) {
                String.format("$ %.0f", number)
            } else {
                String.format("$ %.2f", number)
            }
        }
    }
}