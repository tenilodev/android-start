package com.tenilodev.androidstarter.ui.main

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.tenilodev.androidstarter.ui.base.BasePresenter
import com.tenilodev.androidstarter.ui.base.ViewCallback
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainView>()  {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun testExecute(){
        println("on resume from lifecycle-aware")
        val disposable = Observable.just(listOf("satu","dua","tiga"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { Observable.fromIterable(it) }
                .subscribe({ getMvpView()?.onSuccess(it) },{getMvpView()?.onError(it)})

        compositeDisposable?.add(disposable)

    }



}