package me.sgayazov.pizzatest.di.component

import dagger.Component
import me.sgayazov.pizzatest.di.module.AppModule
import me.sgayazov.pizzatest.di.module.MainScreenModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    operator fun plus(module: MainScreenModule): MainScreenComponent
}