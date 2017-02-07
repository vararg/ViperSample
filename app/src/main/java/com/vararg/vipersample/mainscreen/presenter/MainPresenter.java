package com.vararg.vipersample.mainscreen.presenter;

import com.vararg.vipersample.mainscreen.domain.GetUsersInteractor;
import com.vararg.vipersample.mainscreen.domain.UserViewModel;
import com.vararg.vipersample.mainscreen.router.MainRouter;
import com.vararg.vipersample.mainscreen.view.MainViewCallbacks;

import java.util.Collection;

/**
 * Created by vararg on 06-02-17.
 */

public class MainPresenter {
    private GetUsersInteractor interactor;
    private Collection<UserViewModel> cachedData;

    //TODO add router
    private MainRouter router;

    private MainViewCallbacks view;

    public MainPresenter(GetUsersInteractor interactor) {
        this.interactor = interactor;
    }

    public void dropView() {
        this.view = null;
    }

    protected void onDropView() {
        interactor.unsubscribe();
    }

    public void takeView(MainViewCallbacks view) {
        this.view = view;
        onTakeView(view);
    }

    protected void onTakeView(MainViewCallbacks view) {
        if (cachedData != null) {
            view.onUsersReceived(cachedData);
        }
    }

    public void takeRouter(MainRouter router) {
        this.router = router;
        onTakeRouter(router);
    }

    public void dropRouter() {
        this.router = null;
        onDropRouter();
    }

    protected void onDropRouter() {

    }

    protected void onTakeRouter(MainRouter router) {

    }

    public void fetchData(int count) {
        view.showProgress();
        interactor.execute(users ->
                {
                    view.hideProgress();
                    view.onUsersReceived(users);
                },
                throwable -> {
                    view.hideProgress();
                    view.showError();
                }, count);
    }
}
