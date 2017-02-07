package com.vararg.vipersample.data.users;

import android.content.res.Resources;

import com.vararg.vipersample.network.retrofit.GitHubService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Retrofit;

/**
 * Created by vararg on 27-01-17.
 */

public class UserStorage {

    private GitHubService service;

    public UserStorage(Retrofit retrofit) {
        service = retrofit.create(GitHubService.class);
    }

    public Flowable<Collection<User>> getUsers(int amount) {
        return service.getUsers(0, 1, amount);
        //return Flowable.just(generateUsers(amount));
    }

    private static List<User> generateUsers(int count) {
        List<User> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(new User(i, "User_" + i, null, null));
        }

        return list;
    }
}
