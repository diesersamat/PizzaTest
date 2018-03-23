package me.sgayazov.pizzatest.network


import io.reactivex.Completable
import io.reactivex.Single
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.PizzaWrapper
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface PizzaService {

    @GET("ozt3z")
    fun getIngredientsList(): Single<List<Ingredient>>

    @GET("150da7")
    fun getDrinksList(): Single<List<Drink>>

    @GET("dokm7")
    fun getPizzasList(): Single<PizzaWrapper>

    @POST
    fun createOrder(@Url url: String, @Body order: HashMap<String, MutableList<Any>>): Single<Any>
}