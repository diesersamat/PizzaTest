package me.sgayazov.pizzatest.presenter

import io.reactivex.disposables.Disposable
import me.sgayazov.pizzatest.activity.BaseView
import me.sgayazov.pizzatest.dataprovider.Interactor

abstract class BasePresenter<out V : BaseView>(val view: V) {
    var interactor: Interactor = Interactor()

    private val listOfDisposable: MutableList<Disposable> = mutableListOf()

    fun onStop() {
        listOfDisposable.forEach({ it.dispose() })
    }

    protected fun addSubscription(disposable: Disposable) {
        listOfDisposable.add(disposable)
    }
}