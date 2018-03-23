package me.sgayazov.pizzatest.domain

import android.os.Parcel
import android.os.Parcelable

class Pizza(
        val name: String,
        val ingredients: List<Long>,
        val imageUrl: String?
) : CartItem, Parcelable {
    var basePrice: Double = 0.0

    var ingredientObjects = mutableListOf<Ingredient>()

    fun sumOfIngredients(): Double {
        val sumOfIngredients = 0.0
        ingredientObjects.forEach({ ingredient -> sumOfIngredients + ingredient.price })
        return sumOfIngredients
    }

    fun ingredientsToString(): String = ingredientObjects.joinToString { it.name }

    constructor(source: Parcel) : this(
            source.readString(),
            ArrayList<Long>().apply { source.readList(this, Long::class.java.classLoader) },
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeList(ingredients)
        writeString(imageUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Pizza> = object : Parcelable.Creator<Pizza> {
            override fun createFromParcel(source: Parcel): Pizza = Pizza(source)
            override fun newArray(size: Int): Array<Pizza?> = arrayOfNulls(size)
        }
    }
}