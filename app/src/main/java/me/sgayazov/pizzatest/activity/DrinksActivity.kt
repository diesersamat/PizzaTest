package me.sgayazov.pizzatest.activity

import android.os.Bundle
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.presenter.DrinksPresenter
import javax.inject.Inject

class DrinksActivity : BaseActivity() {

    @Inject
    lateinit var presenter: DrinksPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks)
    }

    fun loadDrinksList() {
        TODO()
    }

    fun showLoadError() {
        TODO()
    }

    fun showProgress() {
        TODO()
    }

    fun showDrinksList(data: List<Drink>) {
        TODO()
    }

    fun addDrinkToCart(drink: Drink) {
        TODO()
    }
}
