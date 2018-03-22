package me.sgayazov.pizzatest

import android.app.Application
import me.sgayazov.pizzatest.di.component.AppComponent
import me.sgayazov.pizzatest.di.component.DaggerAppComponent
import me.sgayazov.pizzatest.di.module.AppModule

class PizzaApp : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}