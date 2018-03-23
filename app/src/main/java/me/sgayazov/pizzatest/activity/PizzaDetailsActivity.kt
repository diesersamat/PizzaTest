package me.sgayazov.pizzatest.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.sgayazov.pizzatest.PizzaApp
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.adapter.IngredientsListAdapter
import me.sgayazov.pizzatest.di.module.DetailScreenModule
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.domain.Pizza
import me.sgayazov.pizzatest.network.ImageLoader
import me.sgayazov.pizzatest.presenter.PizzaDetailsPresenter
import me.sgayazov.pizzatest.utils.EXTRA_BASE_PRICE
import me.sgayazov.pizzatest.utils.EXTRA_PIZZA
import me.sgayazov.pizzatest.utils.Utils
import javax.inject.Inject

class PizzaDetailsActivity : BaseActivity(), PizzaDetailsView {

    override fun inject() {
        (application as PizzaApp).component.plus(DetailScreenModule(this)).inject(this)
    }

    @Inject
    lateinit var presenter: PizzaDetailsPresenter

    private lateinit var recycler: RecyclerView
    private lateinit var pizzaImage: AppCompatImageView
    private lateinit var bottomButton: View
    private lateinit var totalPrice: TextView
    private lateinit var mainView: ViewGroup
    private lateinit var progressBar: View
    private lateinit var errorView: View

    private lateinit var ingredientsListAdapter: IngredientsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza)
        recycler = findViewById(R.id.ingredients_recycler)
        pizzaImage = findViewById(R.id.pizza_image)
        bottomButton = findViewById(R.id.bottom_button)
        totalPrice = findViewById(R.id.total_price)
        mainView = findViewById(R.id.main_view)
        progressBar = findViewById(R.id.loader)
        errorView = findViewById(R.id.error_layout)
        ingredientsListAdapter = IngredientsListAdapter(layoutInflater, { ingredientClicked(it) })
        recycler.isNestedScrollingEnabled = false
        recycler.adapter = ingredientsListAdapter
    }

    override fun onResume() {
        super.onResume()
        showPizza(intent.extras?.getParcelable(EXTRA_PIZZA), intent.extras.getDouble(EXTRA_BASE_PRICE))
        loadIngredientsList()
    }

    private fun addPizzaToCart() {
        presenter.addPizzaToCart()
        showAddedToCartSnackBar(mainView)
    }

    private fun showPizza(pizza: Pizza?, basePrice: Double) {
        if (pizza != null) {
            pizza.imageUrl?.let { ImageLoader.loadImage(this, pizza.imageUrl, pizzaImage) }
            showPrice(pizza.finalPrice())
            supportActionBar?.title = pizza.name
            bottomButton.setOnClickListener { addPizzaToCart() }
            presenter.pizzaLoaded(pizza)
            ingredientsListAdapter.selectedIngredients = pizza.ingredients
        } else {
            pizzaImage.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.custom))
            supportActionBar?.title = getString(R.string.custom_pizza)
            bottomButton.setOnClickListener { addPizzaToCart() }
            val customPizza = Pizza()
            customPizza.basePrice = basePrice
            presenter.customPizza = customPizza
            showPrice(customPizza.finalPrice())
            ingredientsListAdapter.selectedIngredients = customPizza.ingredients
        }
    }

    override fun showPrice(finalPrice: Double) {
        totalPrice.text = Utils.formatPrice(finalPrice)
    }

    private fun loadIngredientsList() {
        showProgress()
        presenter.loadIngredientsList()
    }

    override fun showLoadError() {
        errorView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        recycler.visibility = View.GONE
    }

    private fun showProgress() {
        errorView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        recycler.visibility = View.GONE
    }

    override fun showIngredientsList(data: List<Ingredient>) {
        ingredientsListAdapter.items = data
        errorView.visibility = View.GONE
        progressBar.visibility = View.GONE
        recycler.visibility = View.VISIBLE
    }

    private fun ingredientClicked(ingredient: Ingredient) {
        presenter.addOrRemoveIngredient(ingredient)
    }
}

interface PizzaDetailsView : BaseView {
    fun showIngredientsList(data: List<Ingredient>)
    fun showLoadError()
    fun showPrice(finalPrice: Double)
}