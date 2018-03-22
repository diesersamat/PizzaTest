package me.sgayazov.pizzatest.presenter

import me.sgayazov.pizzatest.activity.MainView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.domain.Pizza
import javax.inject.Inject


class MainPresenter @Inject constructor(view: MainView, interactor: Interactor) : BasePresenter<MainView>(view, interactor) {

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