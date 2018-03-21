package me.sgayazov.pizzatest.dataprovider

import io.reactivex.Completable
import io.reactivex.Single
import me.sgayazov.pizzatest.domain.CartItem
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.PizzaWrapper
import me.sgayazov.pizzatest.network.PizzaService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.myjson.com/bins"
private const val ORDER_URL = "http://httpbin.org/post"

class NetworkDataProvider : BaseDataProvider {

    private var apiService: PizzaService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().build())
            .build()
            .create(PizzaService::class.java)

    override fun getPizzasList(): Single<PizzaWrapper> {
        return apiService.getPizzasList()
    }

    override fun getDrinksList(): Single<List<Drink>> {
        return apiService.getDrinksList()
    }

    override fun getIngredientsList(): Single<List<Ingredient>> {
        return apiService.getIngredientsList()
    }

    override fun makeOrder(cartItemList: List<CartItem>): Completable {
        val orderMap: HashMap<String, MutableList<Any>> = HashMap()
        orderMap["drinks"] = mutableListOf()
        orderMap["pizzas"] = mutableListOf()
        cartItemList.forEach({ cartItem ->
            if (cartItem is Drink) {
                orderMap["drinks"]?.add(cartItem)

            } else if (cartItem is PizzaService) {
                orderMap["pizzas"]?.add(cartItem)
            }
        })
        return apiService.createOrder(ORDER_URL, orderMap)
    }
}