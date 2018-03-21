package me.sgayazov.pizzatest.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_pizza.*
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.Pizza
import me.sgayazov.pizzatest.presenter.PizzaDetailsPresenter
import javax.inject.Inject

class PizzaDetailsActivity : BaseActivity() {

    @Inject
    lateinit var presenter: PizzaDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun addPizzaToCart(pizza: Pizza) {
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
