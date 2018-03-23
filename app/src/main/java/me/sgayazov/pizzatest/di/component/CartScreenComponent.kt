package me.sgayazov.pizzatest.di.component

import dagger.Subcomponent
import me.sgayazov.pizzatest.activity.CartActivity
import me.sgayazov.pizzatest.di.PerActivity
import me.sgayazov.pizzatest.di.module.CartScreenModule

@PerActivity
@Subcomponent(modules = [(CartScreenModule::class)])
interface CartScreenComponent {
    fun inject(activity: CartActivity)
}