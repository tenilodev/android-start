package com.tenilodev.androidstarter.ui.base

import android.arch.lifecycle.LifecycleRegistry
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity() {

    private val lifecycleRegistry = LifecycleRegistry(this)

    fun setBaseFragment(@IdRes containerViewId : Int, newFragment : Fragment, tag : String?){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId,newFragment,tag)
        fragmentTransaction.commit()
    }

    fun setContentFragment(@IdRes containerViewId : Int, newFragment : Fragment, tag : String?){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId,newFragment,tag)
        fragmentTransaction.addToBackStack("home")
        fragmentTransaction.commit()
    }

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }




}