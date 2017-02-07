package com.vararg.vipersample.data.users;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by vararg on 27-01-17.
 */

public class UserStorage {

    public UserStorage(Resources resources) {

    }


    public Flowable<List<User>> getUsers(int amount) {
        return Flowable.just(generateUsers(amount));
    }

    private static List<User> generateUsers(int count) {
        List<User> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(new User(i, "User_" + i, null, null));
        }

        return list;
    }
}
