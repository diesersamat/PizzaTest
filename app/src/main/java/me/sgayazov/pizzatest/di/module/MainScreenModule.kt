package me.sgayazov.pizzatest.di.module

import dagger.Module
import dagger.Provides
import me.sgayazov.pizzatest.activity.MainView
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.di.PerActivity
import me.sgayazov.pizzatest.presenter.MainPresenter

@Module
class MainScreenModule(val view: MainView) {

    @Provides
    @PerActivity
    fun providesFeaturePresenter(view: MainView, interactor: Interactor): MainPresenter {
        return MainPresenter(view, interactor)
    }

    @Provides
    @PerActivity
    fun providesFeatureView(): MainView {
        return view
    }

}