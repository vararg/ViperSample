package com.vararg.vipersample.app;

import com.vararg.vipersample.mainscreen.di.MainScreenModule;
import com.vararg.vipersample.mainscreen.di.MainScreenSubcomponent;

import dagger.Component;

/**
 * Created by vararg on 27-01-17.
 */

@Component(modules = {AppModule.class})
public interface AppComponent {
    MainScreenSubcomponent plus(MainScreenModule mainScreenModule);
}
