package com.vararg.vipersample.app;

import com.vararg.vipersample.mainscreen.di.MainScreenModule;
import com.vararg.vipersample.mainscreen.di.MainScreenSubcomponent;
import com.vararg.vipersample.network.retrofit.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vararg on 27-01-17.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    MainScreenSubcomponent plus(MainScreenModule mainScreenModule);
}
