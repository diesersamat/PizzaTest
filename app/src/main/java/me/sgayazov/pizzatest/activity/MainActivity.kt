package me.sgayazov.pizzatest.activity

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.adapter.PizzaListAdapter
import me.sgayazov.pizzatest.domain.Pizza
import me.sgayazov.pizzatest.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var customPizza: View
    private lateinit var progressBar: View
    private lateinit var errorView: View
    private val pizzaListAdapter = PizzaListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        customPizza = findViewById(R.id.floating_action_button)
        progressBar = findViewById(R.id.loader)
        errorView = findViewById(R.id.error_layout)

        recyclerView.adapter = pizzaListAdapter
    }

    override fun onResume() {
        super.onResume()
        loadPizzaList()
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
        presenter.addPizzaToCart(pizza)
    }

    private fun loadPizzaList() {
        presenter.loadPizzaList()
    }

    override fun showLoadError() {
        TODO()
    }

    fun showProgress() {
        TODO()
    }

    override fun showPizzaList(data: List<Pizza>) {
        pizzaListAdapter.setItems(data)
    }
}

interface MainView : BaseView {
    fun showPizzaList(data: List<Pizza>)
    fun showLoadError()
}