package me.sgayazov.pizzatest.activity

import android.os.Bundle
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.Pizza
import me.sgayazov.pizzatest.presenter.PizzaDetailsPresenter
import javax.inject.Inject

class PizzaDetailsActivity : BaseActivity() {

    @Inject
    lateinit var presenter: PizzaDetailsPresenter

    private lateinit var recycler: RecyclerView
    private lateinit var pizzaImage: AppCompatImageView
    private lateinit var bottomButton: View
    private lateinit var totalPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza)
        recycler = findViewById(R.id.ingredients_recycler)
        pizzaImage = findViewById(R.id.pizza_image)
        bottomButton = findViewById(R.id.bottom_button)
        totalPrice = findViewById(R.id.total_price)
    }

    fun addPizzaToCart(pizza: Pizza) {
        TODO()
    }

    fun showPizza(pizza: Pizza) {
        TODO()
    }

    fun loadIngredientsList() {
        TODO()
    }

    fun showLoadError() {
        TODO()
    }

    fun showProgress() {
        TODO()
    }

    fun showIngredientsList(data: List<Ingredient>) {
        TODO()
    }

    fun ingredientClicked(ingredient: Ingredient) {
        TODO()
    }
}
