package me.sgayazov.pizzatest.activity

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.presenter.CartPresenter
import javax.inject.Inject

class CartActivity : BaseActivity() {
    override fun inject() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var presenter: CartPresenter

    private lateinit var recycler: RecyclerView
    private lateinit var checkoutSuccessView: View
    private lateinit var bottomButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        recycler = findViewById(R.id.cart_recycler)
        checkoutSuccessView = findViewById(R.id.checkout_success_view)
        bottomButton = findViewById(R.id.bottom_button)
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

interface CartView : BaseView {

}
