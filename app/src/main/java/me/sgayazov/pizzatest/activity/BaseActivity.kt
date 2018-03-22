package me.sgayazov.pizzatest.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.sgayazov.pizzatest.R


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    fun showAddedToCartSnackBar(containerLayout: ViewGroup) {
        val snackBar = Snackbar.make(containerLayout, "", Snackbar.LENGTH_LONG)
        val layout = snackBar.view as Snackbar.SnackbarLayout
        val textView = layout.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        textView.visibility = View.INVISIBLE
        val snackView = layoutInflater.inflate(R.layout.added_to_cart_notification_layout, containerLayout, false)
        layout.addView(snackView, 0)
        snackBar.show()
    }

    abstract fun inject()
}

interface BaseView {

}