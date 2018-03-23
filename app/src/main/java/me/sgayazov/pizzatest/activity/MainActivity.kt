package me.sgayazov.pizzatest.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import me.sgayazov.pizzatest.PizzaApp
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.adapter.PizzaListAdapter
import me.sgayazov.pizzatest.di.module.MainScreenModule
import me.sgayazov.pizzatest.domain.Pizza
import me.sgayazov.pizzatest.presenter.MainPresenter
import me.sgayazov.pizzatest.utils.EXTRA_PIZZA
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var mainView: FrameLayout
    private lateinit var progressBar: View
    private lateinit var errorView: View
    private val pizzaListAdapter = PizzaListAdapter(this, { openPizzaDetails(it) }, { addPizzaToCart(it) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        mainView = findViewById(R.id.main_view)
        findViewById<View>(R.id.floating_action_button).setOnClickListener { openCustomPizza() }
        progressBar = findViewById(R.id.loader)
        errorView = findViewById(R.id.error_layout)

        recyclerView.adapter = pizzaListAdapter
    }

    override fun onResume() {
        super.onResume()
        loadPizzaList()
    }

    private fun openPizzaDetails(pizza: Pizza) {
        val intent = Intent(this, PizzaDetailsActivity::class.java)
        intent.putExtra(EXTRA_PIZZA, pizza)
        startActivity(intent)
    }

    private fun openCustomPizza() {
        startActivity(Intent(this, PizzaDetailsActivity::class.java))
    }

    private fun openCart() {
        startActivity(Intent(this, CartActivity::class.java))
    }

    private fun addPizzaToCart(pizza: Pizza) {
        presenter.addPizzaToCart(pizza)
        showAddedToCartSnackBar(mainView)
    }

    private fun loadPizzaList() {
        showProgress()
        presenter.loadPizzaList()
    }

    override fun showLoadError() {
        errorView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.GONE
    }

    private fun showProgress() {
        errorView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun showPizzaList(data: List<Pizza>) {
        pizzaListAdapter.items = data
        errorView.visibility = View.GONE
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun inject() {
        (application as PizzaApp).component.plus(MainScreenModule(this)).inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.cart_item -> {
            openCart()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}

interface MainView : BaseView {
    fun showPizzaList(data: List<Pizza>)
    fun showLoadError()
}