package me.sgayazov.pizzatest.activity

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import me.sgayazov.pizzatest.PizzaApp
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.adapter.DrinksListAdapter
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

    private lateinit var recycler: RecyclerView
    private lateinit var progressBar: View
    private lateinit var errorView: View
    private lateinit var mainView: ViewGroup

    private lateinit var drinkListAdapter: DrinksListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks)
        recycler = findViewById(R.id.recycler_view)
        progressBar = findViewById(R.id.loader)
        errorView = findViewById(R.id.error_layout)
        mainView = findViewById(R.id.main_view)

        drinkListAdapter = DrinksListAdapter(layoutInflater, { addDrinkToCart(it) })
        recycler.adapter = drinkListAdapter
    }

    override fun onResume() {
        super.onResume()
        loadDrinksList()
    }

    private fun loadDrinksList() {
        showProgress()
        presenter.loadDrinksList()
    }

    override fun showLoadError() {
        errorView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        recycler.visibility = View.GONE
    }

    private fun showProgress() {
        errorView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        recycler.visibility = View.GONE
    }

    override fun showDrinksList(data: List<Drink>) {
        drinkListAdapter.items = data
        errorView.visibility = View.GONE
        progressBar.visibility = View.GONE
        recycler.visibility = View.VISIBLE
    }

    private fun addDrinkToCart(drink: Drink) {
        presenter.addDrinkToCart(drink)
    }

    override fun showAddedNotification() {
        showAddedToCartSnackBar(mainView)
    }
}

interface DrinksView : BaseView {
    fun showDrinksList(data: List<Drink>)
    fun showLoadError()
    fun showAddedNotification()
}