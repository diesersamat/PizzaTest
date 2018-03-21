package me.sgayazov.pizzatest.network


import io.reactivex.Completable
import io.reactivex.Single
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.PizzaWrapper
import retrofit2.http.*

interface PizzaService {

    @GET("/ozt3z")
    fun getIngredientsList(@Query("count") count: Int): Single<List<Ingredient>>

    @GET("/150da7")
    fun getDrinksList(@Query("tags") tags: String): Single<List<Drink>>

    @GET("/dokm7")
    fun getPizzasList(@Query("tags") tags: String): Single<PizzaWrapper>

    @POST
    fun createOrder(@Url url: String, @Body order: HashMap<String, Any>): Completable
}