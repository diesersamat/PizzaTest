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


class IngredientsListAdapter(private val inflater: LayoutInflater,
                             private val listener: (Ingredient) -> Unit) : BaseAdapter<IngredientsListAdapter.IngredientsViewHolder, Ingredient>() {

    lateinit var selectedIngredients: MutableList<Long>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val view = inflater.inflate(R.layout.item_ingredient, parent, false)
        return IngredientsViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        items?.get(position)?.let { ingredient ->
            holder.title.text = ingredient.name
            holder.price.text = Utils.formatPrice(ingredient.price)
            holder.checkBox.isChecked = selectedIngredients.contains(ingredient.id)
            val onClickListener: (View) -> Unit = {
                if (selectedIngredients.contains(ingredient.id)) {
                    selectedIngredients.remove(ingredient.id)
                } else {
                    selectedIngredients.add(ingredient.id)
                }
                listener(ingredient)
                notifyItemChanged(position)
            }
            holder.itemView.setOnClickListener(onClickListener)
            holder.checkBox.setOnClickListener(onClickListener)
        }
    }


    class IngredientsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val price: TextView = view.findViewById(R.id.price)
        val checkBox: AppCompatCheckBox = view.findViewById(R.id.checkbox)
    }
}