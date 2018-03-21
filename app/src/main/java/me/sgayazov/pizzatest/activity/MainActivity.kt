package me.sgayazov.pizzatest.activity

import android.os.Bundle
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.Pizza
import me.sgayazov.pizzatest.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openPizzaDetails(pizza: Pizza) {
        TODO()
    }

    fun openCustomPizza() {
        TODO()
    }

    fun openCart() {
        TODO()
    }

    fun addPizzaToCart(pizza: Pizza) {
        TODO()
    }

    fun loadPizzaList() {
        TODO()
    }

    fun showLoadError() {
        TODO()
    }

    fun showProgress() {
        TODO()
    }

    fun showPizzaList(data: List<Pizza>) {
        TODO()
    }
}
