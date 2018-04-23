package com.tenilodev.androidstarter

import com.tenilodev.androidstarter.injection.AppComponent
import com.tenilodev.androidstarter.injection.DaggerAppComponent
import com.tenilodev.androidstarter.injection.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AndroidStarterApplication : DaggerApplication() {


    lateinit var component : AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent.builder()
                .application(this)
                .networkModule(NetworkModule(Config.base_url))
                .build()
        component.inject(this)
        return component
    }

    override fun onCreate() {
        super.onCreate()
    }

}