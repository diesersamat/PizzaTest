package me.sgayazov.pizzatest.domain

import android.os.Parcel
import android.os.Parcelable

class Pizza(
        val name: String = "",
        val ingredients: MutableList<Long> = mutableListOf(),
        val imageUrl: String? = "",
        var basePrice: Double = 0.0,
        var ingredientObjects: MutableList<Ingredient> = mutableListOf<Ingredient>()
) : Parcelable {
    fun finalPrice() = sumOfIngredients() + basePrice

    private fun sumOfIngredients(): Double {
        var sumOfIngredients = 0.0
        ingredientObjects.forEach({ ingredient -> sumOfIngredients += ingredient.price })
        return sumOfIngredients
    }

    fun ingredientsToString(): String = ingredientObjects.joinToString { it.name }

    constructor(source: Parcel) : this(
            source.readString(),
            ArrayList<Long>().apply { source.readList(this, Long::class.java.classLoader) },
            source.readString(),
            source.readDouble(),
            source.createTypedArrayList(Ingredient.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeList(ingredients)
        writeString(imageUrl)
        writeDouble(basePrice)
        writeTypedList(ingredientObjects)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Pizza> = object : Parcelable.Creator<Pizza> {
            override fun createFromParcel(source: Parcel): Pizza = Pizza(source)
            override fun newArray(size: Int): Array<Pizza?> = arrayOfNulls(size)
        }
    }
}