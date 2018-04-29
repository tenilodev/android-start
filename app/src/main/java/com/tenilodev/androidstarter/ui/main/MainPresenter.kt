package com.tenilodev.androidstarter.ui.main

import com.tenilodev.androidstarter.ui.base.BasePresenter
import com.tenilodev.androidstarter.ui.base.ViewCallback
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainView>()  {

    private var disposable : Disposable? = null

    override fun attachView(vb: MainView) {
        super.attachView(vb)
    }

    override fun detachView() {
        super.detachView()
        disposable?.dispose()
    }

    fun testExecute(){
        Observable.just(listOf("satu","dua","tiga"))
                .flatMap { Observable.fromIterable(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { disposable = it }
                .subscribe({ getMvpView()?.onSuccess(it) },{getMvpView()?.onError("error",it)})

    }
}