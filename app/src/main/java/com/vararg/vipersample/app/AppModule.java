package com.vararg.vipersample.app;

import android.app.Application;
import android.content.res.Resources;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by vararg on 27-01-17.
 */

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Main
    Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Job
    Scheduler provideJobScheduler() {
        return Schedulers.computation();
    }

    @Provides
    Resources provideResources() {
        return application.getResources();
    }
}
