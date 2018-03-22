package me.sgayazov.pizzatest.presenter

import me.sgayazov.pizzatest.activity.MainView
import me.sgayazov.pizzatest.domain.Pizza

class MainPresenter(view: MainView) : BasePresenter<MainView>(view) {

    fun loadPizzaList() {
        addSubscription(interactor.getPizzasList().subscribe { result, error ->
            result?.let { view.showPizzaList(it) }
            error?.let { view.showLoadError() }
        })
    }

    fun addPizzaToCart(pizza: Pizza) {
        TODO()
    }
}