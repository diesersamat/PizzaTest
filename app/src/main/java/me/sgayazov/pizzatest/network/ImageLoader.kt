package me.sgayazov.pizzatest.network

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageLoader {
    companion object {
        fun loadImage(context: Context, url: String, imageView: ImageView) {
            if (url.isNotEmpty()) {
                Picasso.with(context).load(url).into(imageView)
            }
        }
    }
}