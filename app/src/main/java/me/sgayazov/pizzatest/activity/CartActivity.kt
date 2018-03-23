package me.sgayazov.pizzatest.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import me.sgayazov.pizzatest.PizzaApp
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.adapter.CartListAdapter
import me.sgayazov.pizzatest.di.module.CartScreenModule
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.presenter.CartPresenter
import javax.inject.Inject

class CartActivity : BaseActivity(), CartView {

    override fun inject() {
        (application as PizzaApp).component.plus(CartScreenModule(this)).inject(this)

    }

    @Inject
    lateinit var presenter: CartPresenter

    private lateinit var cartListAdapter: CartListAdapter

    private lateinit var recycler: RecyclerView
    private lateinit var progressBar: View
    private lateinit var errorView: View
    private lateinit var retryButton: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        recycler = findViewById(R.id.cart_recycler)
        findViewById<View>(R.id.bottom_button).setOnClickListener { startCheckout() }
        progressBar = findViewById(R.id.loader)
        errorView = findViewById(R.id.error_layout)
        retryButton = findViewById(R.id.retry_button)

        cartListAdapter = CartListAdapter(layoutInflater, { removeCartItem(it) })
        recycler.adapter = cartListAdapter
    }

    override fun onResume() {
        super.onResume()
        loadCartItemsList()
    }

    private fun openDrinks() {
        startActivity(Intent(this, DrinksActivity::class.java))
    }

    private fun loadCartItemsList() {
        showProgress()
        presenter.loadCartItemsList()
    }

    override fun showLoadError(onRetry: () -> Unit) {
        errorView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        recycler.visibility = View.GONE
        retryButton.setOnClickListener { onRetry() }
    }

    private fun showProgress() {
        errorView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        recycler.visibility = View.GONE
    }

    override fun showCartItemsList(data: List<CartItem>) {
        cartListAdapter.items = data
        errorView.visibility = View.GONE
        progressBar.visibility = View.GONE
        recycler.visibility = View.VISIBLE
    }

    private fun removeCartItem(cartItem: CartItem) {
        showProgress()
        presenter.removeCartItem(cartItem)
    }

    private fun startCheckout() {
        showProgress()
        presenter.startCheckout()
    }

    override fun showSuccess() {
        finish()
        startActivity(Intent(this, SuccessActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cart_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.drink_item -> {
            openDrinks()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}

interface CartView : BaseView {
    fun showCartItemsList(data: List<CartItem>)
    fun showLoadError(onRetry: () -> Unit)
    fun showSuccess()
}
