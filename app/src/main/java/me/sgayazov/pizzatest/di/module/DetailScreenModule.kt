package me.sgayazov.pizzatest.di.module

import dagger.Module
import dagger.Provides
import me.sgayazov.pizzatest.activity.PizzaDetailsView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.di.PerActivity
import me.sgayazov.pizzatest.presenter.PizzaDetailsPresenter

@Module
class DetailScreenModule(val view: PizzaDetailsView) {

    @Provides
    @PerActivity
    fun providesDetailPresenter(view: PizzaDetailsView, interactor: Interactor): PizzaDetailsPresenter {
        return PizzaDetailsPresenter(view, interactor)
    }

    @Provides
    @PerActivity
    fun providesDetailView(): PizzaDetailsView {
        return view
    }

}