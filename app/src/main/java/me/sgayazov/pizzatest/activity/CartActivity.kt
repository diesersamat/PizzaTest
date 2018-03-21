package me.sgayazov.pizzatest.activity

import android.os.Bundle
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.presenter.CartPresenter
import javax.inject.Inject

class CartActivity : BaseActivity() {

    @Inject
    lateinit var presenter: CartPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
    }
}
