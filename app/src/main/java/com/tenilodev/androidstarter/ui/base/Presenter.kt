package com.tenilodev.androidstarter.ui.base

interface Presenter<T : ViewCallback> {
    fun attachView(viewCallback : T)
    fun detachView()
}