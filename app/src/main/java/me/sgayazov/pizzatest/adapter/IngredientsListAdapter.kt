package me.sgayazov.pizzatest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.Ingredient


class IngredientsListAdapter(private val inflater: LayoutInflater) : BaseAdapter<IngredientsListAdapter.IngredientsViewHolder, Ingredient>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val view = inflater.inflate(R.layout.item_ingredient, parent, false)
        return IngredientsViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class IngredientsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}