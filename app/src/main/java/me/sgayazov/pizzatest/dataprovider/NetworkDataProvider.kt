package me.sgayazov.pizzatest.dataprovider

import io.reactivex.Single
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.PizzaWrapper
import me.sgayazov.pizzatest.network.PizzaService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.myjson.com/bins/"
private const val ORDER_URL = "http://httpbin.org/post"

class NetworkDataProvider {

    private var apiService: PizzaService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)).build())
            .build()
            .create(PizzaService::class.java)

    fun getPizzasList(): Single<PizzaWrapper> {
        return apiService.getPizzasList()
    }

    fun getDrinksList(): Single<List<Drink>> {
        return apiService.getDrinksList()
    }

    fun getIngredientsList(): Single<List<Ingredient>> {
        return apiService.getIngredientsList()
    }

    fun makeOrder(cartItemList: List<CartItem>): Single<Any> {
        val orderMap: HashMap<String, MutableList<Any>> = HashMap()
        orderMap["drinks"] = mutableListOf()
        orderMap["pizzas"] = mutableListOf()
        cartItemList.forEach({ cartItem ->
            if (!cartItem.isPizza) {
                orderMap["drinks"]?.add(cartItem)
            } else {
                orderMap["pizzas"]?.add(cartItem)
            }
        })
        TODO()
        return apiService.createOrder(ORDER_URL, orderMap)
    }
}