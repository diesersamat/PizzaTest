package me.sgayazov.pizzatest.activity

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import me.sgayazov.pizzatest.PizzaApp
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.di.module.DrinksScreenModule
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.presenter.DrinksPresenter
import javax.inject.Inject

class DrinksActivity : BaseActivity(), DrinksView {
    override fun inject() {
        (application as PizzaApp).component.plus(DrinksScreenModule(this)).inject(this)
    }

    @Inject
    lateinit var presenter: DrinksPresenter

    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks)
        recycler = findViewById(R.id.recycler_view)
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

    fun showAddedToast() {
        TODO()
    }
}

interface DrinksView : BaseView {

}