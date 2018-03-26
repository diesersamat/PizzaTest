package me.sgayazov.pizzatest.presenter

import me.sgayazov.pizzatest.activity.CartView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.domain.CartItem

class CartPresenter(view: CartView, interactor: Interactor) : BasePresenter<CartView>(view, interactor) {

    fun loadCartItemsList() {
        addSubscription(interactor.getCartItems().subscribe { result, error ->
            result?.let { showLoadedCart(it) }
            error?.let { view.showLoadError({ loadCartItemsList() }) }
        })
    }

    fun removeCartItem(cartItem: CartItem) {
        addSubscription(interactor.removeCartItem(cartItem).subscribe { result, error ->
            result?.let { showLoadedCart(it) }
            error?.let { view.showLoadError({ removeCartItem(cartItem) }) }
        })
    }

    private fun showLoadedCart(cartList: List<CartItem>) {
        var totalPrice = 0.0
        cartList.forEach({ totalPrice += it.price })
        view.showCartItemsList(cartList, totalPrice)
    }

    fun startCheckout() {
        addSubscription(interactor.makeOrder().subscribe { result, error ->
            result?.let { view.showSuccess() }
            error?.let { view.showLoadError({ startCheckout() }) }
        })
    }
}