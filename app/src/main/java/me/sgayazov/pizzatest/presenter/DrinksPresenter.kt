package me.sgayazov.pizzatest.presenter

import me.sgayazov.pizzatest.activity.DrinksView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.domain.Drink

class DrinksPresenter(view: DrinksView, interactor: Interactor) : BasePresenter<DrinksView>(view, interactor) {

    fun loadDrinksList() {
        addSubscription(interactor.getDrinksList().subscribe { result, error ->
            result?.let { view.showDrinksList(it) }
            error?.let { view.showLoadError() }
        })
    }

    fun addDrinkToCart(drink: Drink) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}