package me.sgayazov.pizzatest.activity

import android.os.Bundle
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.presenter.CartPresenter
import javax.inject.Inject

class CartActivity : BaseActivity() {

    @Inject
    lateinit var presenter: CartPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
    }

    fun openDrinks() {
        TODO()
    }

    fun loadCartItemsList() {
        TODO()
    }

    fun showLoadError() {
        TODO()
    }

    fun showProgress() {
        TODO()
    }

    fun showCartItemsList(data: List<CartItem>) {
        TODO()
    }

    fun removeCartItem(cartItem: CartItem) {
        TODO()
    }

    fun startCheckout() {
        TODO()
    }
}
