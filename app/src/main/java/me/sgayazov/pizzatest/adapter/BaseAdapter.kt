package me.sgayazov.pizzatest.adapter

import android.support.v7.widget.RecyclerView

abstract class BaseAdapter<VH : RecyclerView.ViewHolder, T> : RecyclerView.Adapter<VH>() {

    private var items: List<T>? = null


    override fun getItemCount(): Int = items?.size ?: 0


    fun setItems(data: List<T>) {
        this.items = data
        notifyDataSetChanged()
    }
}