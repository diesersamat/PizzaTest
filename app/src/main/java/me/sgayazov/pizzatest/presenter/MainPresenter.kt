package me.sgayazov.pizzatest.presenter

import me.sgayazov.pizzatest.activity.MainView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.domain.Pizza
import javax.inject.Inject


class MainPresenter @Inject constructor(view: MainView, interactor: Interactor) : BasePresenter<MainView>(view, interactor) {

    var basePrice: Double? = null

    fun loadPizzaList() {
        addSubscription(interactor.getPizzasList().subscribe { result, error ->
            result?.let {
                if (!it.isEmpty()) {
                    basePrice = it[0].basePrice
                    view.showPizzaList(it)
                } else {
                    view.showLoadError()
                }
            }
            error?.let { view.showLoadError() }
        })
    }

    fun addPizzaToCart(pizza: Pizza) {
        addSubscription(interactor.addPizzaToCart(pizza).subscribe())
    }

    fun openCustomPizza() {
        basePrice?.let { view.openCustomPizza(it) }
    }
}