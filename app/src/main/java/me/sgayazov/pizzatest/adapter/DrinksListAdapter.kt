package me.sgayazov.pizzatest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.Drink


class DrinksListAdapter(private val inflater: LayoutInflater) : BaseAdapter<DrinksListAdapter.DrinksViewHolder, Drink>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val view = inflater.inflate(R.layout.item_drink, parent, false)
        return DrinksViewHolder(view)
    }


    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class DrinksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}