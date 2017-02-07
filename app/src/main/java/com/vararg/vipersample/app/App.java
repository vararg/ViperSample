package com.vararg.vipersample.app;

import android.app.Application;

import com.vararg.vipersample.network.retrofit.NetworkModule;

/**
 * Created by vararg on 27-01-17.
 */

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("https://api.github.com"))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
