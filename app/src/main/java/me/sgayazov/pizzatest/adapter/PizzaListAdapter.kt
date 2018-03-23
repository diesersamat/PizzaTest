package me.sgayazov.pizzatest.adapter

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.Pizza
import me.sgayazov.pizzatest.network.ImageLoader
import me.sgayazov.pizzatest.utils.Utils

class PizzaListAdapter(private val context: Context, private val open: (Pizza) -> Unit, private val buy: (Pizza) -> Unit)
    : BaseAdapter<PizzaListAdapter.PizzaViewHolder, Pizza>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_pizza, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        items?.get(position)?.let { pizza ->
            pizza.imageUrl?.let { ImageLoader.loadImage(context, it, holder.image) }
            holder.price.text = Utils.formatPrice(pizza.finalPrice())
            holder.subtitle.text = pizza.ingredientsToString()
            holder.title.text = pizza.name
            holder.itemView.setOnClickListener { open(pizza) }
            holder.price.setOnClickListener { buy(pizza) }
        }
    }

    class PizzaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: AppCompatImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
        val subtitle: TextView = view.findViewById(R.id.subtitle)
        val price: TextView = view.findViewById(R.id.price)
    }
}