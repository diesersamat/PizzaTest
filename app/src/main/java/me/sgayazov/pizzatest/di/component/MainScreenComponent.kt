package me.sgayazov.pizzatest.di.component

import dagger.Subcomponent
import me.sgayazov.pizzatest.activity.MainActivity
import me.sgayazov.pizzatest.di.PerActivity
import me.sgayazov.pizzatest.di.module.MainScreenModule

@PerActivity
@Subcomponent(modules = [(MainScreenModule::class)])
interface MainScreenComponent {
    fun inject(activity: MainActivity)
}