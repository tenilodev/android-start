package com.tenilodev.androidstarter.ui.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import io.reactivex.disposables.CompositeDisposable


abstract class BasePresenter<T : ViewCallback> : Presenter<T>, LifecycleObserver {

    private var viewCallback : T? = null

    var compositeDisposable : CompositeDisposable? = null

    override fun attachView(vb: T) {
        viewCallback = vb
        if(vb is LifecycleOwner){
            val lifecycleOwner = vb as LifecycleOwner
            lifecycleOwner.lifecycle.addObserver(this)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun detachView() {
        viewCallback = null
        compositeDisposable?.dispose()
        println("on pause from lifecycle-aware")
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