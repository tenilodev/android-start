package com.tenilodev.androidstarter.ui.base

interface ViewCallback {
    fun onError(message:String?,throwable: Throwable?)
    fun onProgress(isProgress : Boolean)
}