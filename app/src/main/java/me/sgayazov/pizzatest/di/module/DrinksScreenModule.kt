package me.sgayazov.pizzatest.di.module

import dagger.Module
import dagger.Provides
import me.sgayazov.pizzatest.activity.DrinksView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.di.PerActivity
import me.sgayazov.pizzatest.presenter.DrinksPresenter

@Module
class DrinksScreenModule(val view: DrinksView) {

    @Provides
    @PerActivity
    fun providesDrinksPresenter(view: DrinksView, interactor: Interactor): DrinksPresenter {
        return DrinksPresenter(view, interactor)
    }

    @Provides
    @PerActivity
    fun providesDrinksView(): DrinksView {
        return view
    }

}