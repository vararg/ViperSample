package com.vararg.vipersample.mainscreen.di;

import com.vararg.vipersample.app.Job;
import com.vararg.vipersample.app.Main;
import com.vararg.vipersample.data.DataModule;
import com.vararg.vipersample.data.users.UserStorage;
import com.vararg.vipersample.mainscreen.MainActivity;
import com.vararg.vipersample.mainscreen.domain.GetUsersInteractor;
import com.vararg.vipersample.mainscreen.domain.UserMapper;
import com.vararg.vipersample.mainscreen.presenter.MainPresenter;
import com.vararg.vipersample.mainscreen.router.MainRouter;
import com.vararg.vipersample.mainscreen.router.MainRouterImpl;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

/**
 * Created by vararg on 06-02-17.
 */

@Module(includes = {DataModule.class})
public class MainScreenModule {
    private WeakReference<MainActivity> weakActivity;

    public void setMainActivity(MainActivity mainActivity) {
        this.weakActivity = new WeakReference<>(mainActivity);
    }

    @Provides
    MainRouter provideMainRouter() {
        MainActivity mainActivity = weakActivity.get();
        if (mainActivity != null) return new MainRouterImpl(mainActivity);
        else return null;
    }

    @Provides
    @MainScreenScope
    static GetUsersInteractor provideGetUsersInteractor(@Job Scheduler jobScheduler, @Main Scheduler mainScheduler,
                                                 UserStorage storage, UserMapper userMapper) {
        return new GetUsersInteractor(jobScheduler, mainScheduler, storage, userMapper);
    }

    @Provides
    @MainScreenScope
    static UserMapper provideUserMapper() {
        return new UserMapper();
    }

    @Provides
    @MainScreenScope
    static MainPresenter provideMainPresenter(GetUsersInteractor getUsersInteractor) {
        return new MainPresenter(getUsersInteractor);
    }

}
