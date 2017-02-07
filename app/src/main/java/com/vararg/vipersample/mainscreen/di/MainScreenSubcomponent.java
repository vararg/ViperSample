package com.vararg.vipersample.mainscreen.di;

import com.vararg.vipersample.mainscreen.presenter.MainPresenter;
import com.vararg.vipersample.mainscreen.router.MainRouter;
import com.vararg.vipersample.mainscreen.view.MainView;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by vararg on 06-02-17.
 */

@Singleton
@Subcomponent(modules = MainScreenModule.class)
public interface MainScreenSubcomponent {
    void inject(MainView view);

    MainRouter mainRouter();

    MainPresenter mainPresenter();

}
