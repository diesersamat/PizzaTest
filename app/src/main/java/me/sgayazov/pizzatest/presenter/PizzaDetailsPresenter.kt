package me.sgayazov.pizzatest.presenter

import me.sgayazov.pizzatest.activity.PizzaDetailsView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.Pizza

class PizzaDetailsPresenter(view: PizzaDetailsView, interactor: Interactor) : BasePresenter<PizzaDetailsView>(view, interactor) {

    lateinit var customPizza: Pizza

    fun addPizzaToCart() {
        addSubscription(interactor.addPizzaToCart(customPizza).subscribe {
            view.closeActivity()
        })
    }

    fun loadIngredientsList() {
        addSubscription(interactor.getIngredientsList().subscribe { result, error ->
            result?.let { view.showIngredientsList(it) }
            error?.let { view.showLoadError() }
        })
    }

    fun pizzaLoaded(pizza: Pizza) {
        customPizza = pizza
    }

    fun addOrRemoveIngredient(ingredient: Ingredient) {
        if (customPizza.ingredientObjects.contains(ingredient)) {
            customPizza.ingredientObjects.remove(ingredient)
        } else {
            customPizza.ingredientObjects.add(ingredient)
        }
        view.showPrice(customPizza.finalPrice())
    }

}