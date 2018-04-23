package com.tenilodev.androidstarter.injection;



import com.tenilodev.androidstarter.ui.base.BaseActivity;
import com.tenilodev.androidstarter.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by azisa on 1/9/2018.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract BaseActivity baseActivity();

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();



}
