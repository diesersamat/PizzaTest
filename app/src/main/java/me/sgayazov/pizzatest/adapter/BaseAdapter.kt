package me.sgayazov.pizzatest.adapter

import android.support.v7.widget.RecyclerView

abstract class BaseAdapter<VH : RecyclerView.ViewHolder, T> : RecyclerView.Adapter<VH>() {

    var items: List<T>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items?.size ?: 0

}