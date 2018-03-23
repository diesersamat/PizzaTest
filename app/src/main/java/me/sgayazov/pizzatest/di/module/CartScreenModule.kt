package me.sgayazov.pizzatest.di.module

import dagger.Module
import dagger.Provides
import me.sgayazov.pizzatest.activity.CartView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.di.PerActivity
import me.sgayazov.pizzatest.presenter.CartPresenter

@Module
class CartScreenModule(val view: CartView) {

    @Provides
    @PerActivity
    fun providesCartPresenter(view: CartView, interactor: Interactor): CartPresenter {
        return CartPresenter(view, interactor)
    }

    @Provides
    @PerActivity
    fun providesCartView(): CartView {
        return view
    }

}