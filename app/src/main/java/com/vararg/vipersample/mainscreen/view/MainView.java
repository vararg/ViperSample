package com.vararg.vipersample.mainscreen.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.vararg.vipersample.databinding.ViewMainBinding;
import com.vararg.vipersample.mainscreen.domain.UserViewModel;
import com.vararg.vipersample.mainscreen.presenter.MainPresenter;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by vararg on 27-01-17.
 */

public class MainView extends ConstraintLayout implements MainViewCallbacks {

    private ViewMainBinding binding;
    private UsersAdapter adapter;

    public MainView(Context context) {
        this(context, null);
    }

    public MainView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            binding = ViewMainBinding.bind(this);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }

    @Override
    public void showProgress() {
        binding.progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.progressBar.setVisibility(GONE);
    }

    @Override
    public void showError() {
        binding.errorText.setVisibility(VISIBLE);
    }

    @Override
    public void onUsersReceived(Collection<UserViewModel> users) {
        binding.errorText.setVisibility(GONE);
        adapter.setUsers(users);
    }

    @Inject
    void setPresenter(MainPresenter presenter) {
        binding.button.setOnClickListener(v -> presenter.fetchData(5));
        adapter = new UsersAdapter();
        binding.recyclerView.setAdapter(adapter);
    }
}
