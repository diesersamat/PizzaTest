package me.sgayazov.pizzatest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.CartItem


class CartListAdapter(private val inflater: LayoutInflater) : BaseAdapter<CartListAdapter.CartViewHolder, CartItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = inflater.inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}