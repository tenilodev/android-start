package com.tenilodev.androidstarter.utils

import android.arch.lifecycle.Observer
import com.tenilodev.androidstarter.pojo.Resource
import com.tenilodev.androidstarter.pojo.Status


open class ApiObserver<T> constructor(val onStateListener: OnStateListener<T>) : Observer<Resource<T>> {

    override fun onChanged(resource: Resource<T>?) {

        if(resource?.status == Status.SUCCESS){
            resource.data?.let {
                onStateListener.onSuccess(it)
            }

        }else if(resource?.status == Status.ERROR){
            resource.throwable?.let {
                onStateListener.onError(it)
            }
        }

        if(resource?.status == Status.LOADING){
            onStateListener.onLoading(true)
        }else{
            onStateListener.onLoading(false)
        }
    }

    interface OnStateListener<T> {
        fun onSuccess(data : T)
        fun onError(throwable: Throwable)
        fun onLoading(isLoading: Boolean)
    }

}