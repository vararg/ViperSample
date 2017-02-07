package com.vararg.vipersample.mainscreen.domain;

import com.vararg.vipersample.data.users.UserStorage;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by vararg on 27-01-17.
 */

public class GetUsersInteractor {

    private UserStorage storage;
    private UserMapper mapper;

    private Scheduler subscribeScheduler;
    private Scheduler observeScheduler;
    private CompositeDisposable compositeDisposable;

    public GetUsersInteractor(Scheduler subscribeOn, Scheduler observeOn, UserStorage storage, UserMapper mapper) {
        this.storage = storage;
        this.mapper = mapper;

        subscribeScheduler = subscribeOn;
        observeScheduler = observeOn;

        compositeDisposable = new CompositeDisposable();
    }

    public void execute(Consumer<Collection<UserViewModel>> onNext, Consumer<Throwable> onError, int amount) {

        compositeDisposable.add(flowable(amount).subscribe(onNext, onError));
    }

    protected Flowable<Collection<UserViewModel>> createFlowable(Integer amount) {
        return storage.getUsers(amount)
                .map(mapper::map);
    }

    public final void unsubscribe() {
        // call clear() instead of unsubscribe() to be able to manage new subscriptions
        compositeDisposable.clear();
    }

    private Flowable<Collection<UserViewModel>> flowable(int requestModel) {
        return createFlowable(requestModel)
                .subscribeOn(subscribeScheduler)
                .observeOn(observeScheduler);
    }
}
