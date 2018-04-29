package com.tenilodev.androidstarter.ui.base

import android.icu.lang.UCharacter.GraphemeClusterBreak.T


abstract class BasePresenter<T : ViewCallback> : Presenter<T> {

    private var viewCallback : T? = null

    override fun attachView(vb: T) {
        viewCallback = vb
    }

    override fun detachView() {
        viewCallback = null
    }

    fun isViewAttached(): Boolean {
        return viewCallback != null
    }

    fun getMvpView(): T? {
        return viewCallback
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")

}