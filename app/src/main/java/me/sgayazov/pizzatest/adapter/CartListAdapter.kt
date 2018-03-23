package me.sgayazov.pizzatest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.sgayazov.pizzatest.R
import me.sgayazov.pizzatest.domain.CartItem


class CartListAdapter(private val inflater: LayoutInflater,
                      private val callback: (CartItem) -> Unit) : BaseAdapter<CartListAdapter.CartViewHolder, CartItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = inflater.inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        items?.get(position)?.let { cartItem ->
            holder.title.text = cartItem.name
            holder.price.text = cartItem.price
            holder.delete.setOnClickListener { callback(cartItem) }
        }
    }

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val price: TextView = view.findViewById(R.id.price)
        val delete: View = view.findViewById(R.id.delete)
    }
}