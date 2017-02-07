package com.vararg.vipersample.mainscreen.view;

import com.vararg.vipersample.mainscreen.domain.UserViewModel;

import java.util.Collection;

/**
 * Created by vararg on 27-01-17.
 */

public interface MainViewCallbacks {

    void showProgress();

    void hideProgress();

    void showError();

    void onUsersReceived(Collection<UserViewModel> users);

}
