package com.tenilodev.androidstarter.ui.main

import com.tenilodev.androidstarter.ui.base.ViewCallback

interface MainView : ViewCallback {
    fun onSuccess(string: String)
}