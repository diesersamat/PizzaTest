package me.sgayazov.pizzatest.adapter

import android.support.v7.widget.AppCompatCheckBox
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.Ingredient
import me.sgayazov.pizzatest.utils.Utils


class IngredientsListAdapter(private val inflater: LayoutInflater) : BaseAdapter<IngredientsListAdapter.IngredientsViewHolder, Ingredient>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val view = inflater.inflate(R.layout.item_ingredient, parent, false)
        return IngredientsViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        items?.get(position)?.let {
            holder.title.text = it.name
            holder.price.text = Utils.formatPrice(it.price)
        }
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class IngredientsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val price: TextView = view.findViewById(R.id.price)
        val checkBox: AppCompatCheckBox = view.findViewById(R.id.checkbox)
    }
}