package me.sgayazov.pizzatest.di.module

import dagger.Module
import dagger.Provides
import me.sgayazov.pizzatest.PizzaApp
import me.sgayazov.pizzatest.dataprovider.CacheDataProvider
import me.sgayazov.pizzatest.dataprovider.Interactor
import me.sgayazov.pizzatest.dataprovider.NetworkDataProvider
import javax.inject.Singleton

@Module
class AppModule(val app: PizzaApp) {
    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideInteractor(cacheDataProvider: CacheDataProvider,
                          networkDataProvider: NetworkDataProvider) = Interactor(cacheDataProvider, networkDataProvider)

    @Provides
    @Singleton
    fun provideCacheDataProvider() = CacheDataProvider()

    @Provides
    @Singleton
    fun provideNetworkDataProvider() = NetworkDataProvider()
}
