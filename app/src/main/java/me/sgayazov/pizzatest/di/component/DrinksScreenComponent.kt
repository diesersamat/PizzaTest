package me.sgayazov.pizzatest.di.component

import dagger.Subcomponent
import me.sgayazov.pizzatest.activity.DrinksActivity
import me.sgayazov.pizzatest.di.PerActivity
import me.sgayazov.pizzatest.di.module.DrinksScreenModule

@PerActivity
@Subcomponent(modules = [(DrinksScreenModule::class)])
interface DrinksScreenComponent {
    fun inject(activity: DrinksActivity)
}