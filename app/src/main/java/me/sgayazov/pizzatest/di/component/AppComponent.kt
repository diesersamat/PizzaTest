package me.sgayazov.pizzatest.di.component

import dagger.Component
import me.sgayazov.pizzatest.di.module.*
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    operator fun plus(module: MainScreenModule): MainScreenComponent

    operator fun plus(module: DetailScreenModule): DetailScreenComponent

    operator fun plus(module: DrinksScreenModule): DrinksScreenComponent

    operator fun plus(module: CartScreenModule): CartScreenComponent
}