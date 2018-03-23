package me.sgayazov.pizzatest.presenter

import me.sgayazov.pizzatest.activity.PizzaDetailsView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.domain.Pizza

class PizzaDetailsPresenter(view: PizzaDetailsView, interactor: Interactor) : BasePresenter<PizzaDetailsView>(view, interactor) {

    var customPizza: Pizza? = null

    fun addPizzaToCart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun loadIngredientsList() {
        addSubscription(interactor.getIngredientsList().subscribe { result, error ->
            result?.let { view.showIngredientsList(it) }
            error?.let { view.showLoadError() }
        })
    }

}