package com.vararg.vipersample.data;

import android.content.res.Resources;

import com.vararg.vipersample.app.AppModule;
import com.vararg.vipersample.data.users.UserStorage;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vararg on 27-01-17.
 */

@Module(includes = AppModule.class)
public class DataModule {

    @Provides
    UserStorage provideUserStorage(Resources resources) {
        return new UserStorage(resources);
    }
}
