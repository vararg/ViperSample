package com.vararg.vipersample.mainscreen.router;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by vararg on 06-02-17.
 */

public class MainRouterImpl implements MainRouter{

    private Activity mainActivity;

    public MainRouterImpl(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void navigateTo() {
        Toast.makeText(mainActivity, "Navigated", Toast.LENGTH_SHORT).show();
    }
}
