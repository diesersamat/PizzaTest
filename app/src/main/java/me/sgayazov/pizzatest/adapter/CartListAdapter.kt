package me.sgayazov.pizzatest.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import me.sgayazov.pizzatest.domain.CartItem


class CartListAdapter : BaseAdapter<CartListAdapter.CartViewHolder, CartItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}