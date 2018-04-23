package com.tenilodev.androidstarter.injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;

/**
 * Created by azisa on 1/11/2018.
 */

@Module
public abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(LoginViewModel.class)
//    abstract ViewModel loginViewModel(LoginViewModel loginViewModel);



    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
