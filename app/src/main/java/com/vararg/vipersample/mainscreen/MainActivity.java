package com.vararg.vipersample.mainscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vararg.vipersample.R;
import com.vararg.vipersample.app.App;
import com.vararg.vipersample.mainscreen.di.MainScreenModule;
import com.vararg.vipersample.mainscreen.di.MainScreenSubcomponent;
import com.vararg.vipersample.mainscreen.presenter.MainPresenter;
import com.vararg.vipersample.mainscreen.router.MainRouter;
import com.vararg.vipersample.mainscreen.view.MainView;

/**
 * Created by vararg on 27-01-17.
 */

public class MainActivity extends AppCompatActivity {

    private MainView mainView;
    private MainScreenModule mainScreenModule;
    private MainScreenSubcomponent mainScreenSubcomponent;
    private MainPresenter presenter;
    private MainRouter mainRouter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main);
        mainView = (MainView) findViewById(R.id.view_main);

        mainScreenModule = new MainScreenModule(this);
        mainScreenSubcomponent = ((App) getApplication()).getComponent().plus(mainScreenModule);

        mainScreenSubcomponent.inject(mainView);

        presenter = mainScreenSubcomponent.mainPresenter();
        mainRouter = mainScreenSubcomponent.mainRouter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.takeView(mainView);
        presenter.takeRouter(mainRouter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.dropView();
        presenter.dropRouter();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            mainScreenModule.setMainActivity(null);
        }
    }
}
