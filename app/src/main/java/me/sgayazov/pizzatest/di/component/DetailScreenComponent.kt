package me.sgayazov.pizzatest.di.component

import dagger.Subcomponent
import me.sgayazov.pizzatest.activity.PizzaDetailsActivity
import me.sgayazov.pizzatest.di.PerActivity
import me.sgayazov.pizzatest.di.module.DetailScreenModule

@PerActivity
@Subcomponent(modules = [(DetailScreenModule::class)])
interface DetailScreenComponent {
    fun inject(activity: PizzaDetailsActivity)
}