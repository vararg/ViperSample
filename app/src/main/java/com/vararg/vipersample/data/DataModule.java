package com.vararg.vipersample.data;

import com.vararg.vipersample.data.users.UserStorage;
import com.vararg.vipersample.network.retrofit.NetworkModule;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by vararg on 27-01-17.
 */

@Module(includes = {NetworkModule.class})
public class DataModule {

    @Provides
    UserStorage provideUserStorage(Retrofit retrofit) {
        return new UserStorage(retrofit);
    }
}
