package me.sgayazov.pizzatest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.Drink
import me.sgayazov.pizzatest.utils.formatPrice


class DrinksListAdapter(private val inflater: LayoutInflater,
                        private val listener: (Drink) -> Unit) : BaseAdapter<DrinksListAdapter.DrinksViewHolder, Drink>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val view = inflater.inflate(R.layout.item_drink, parent, false)
        return DrinksViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        items?.get(position)?.let { drink ->
            holder.title.text = drink.name
            holder.price.text = formatPrice(drink.price)
            holder.itemView.setOnClickListener { listener(drink) }
        }
    }

    class DrinksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val price: TextView = view.findViewById(R.id.price)
        val add: View = view.findViewById(R.id.add)
    }
}