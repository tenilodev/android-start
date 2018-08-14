package com.tenilodev.androidstarter.ui.base

interface ViewCallback {
    fun onError(throwable: Throwable)
    fun onProgress(isProgress : Boolean)
}