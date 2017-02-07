package com.vararg.vipersample.network.retrofit;

import com.vararg.vipersample.data.users.User;

import java.util.Collection;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vararg on 07-02-17.
 */

public interface GitHubService {

    @GET("/users")
    Flowable<Collection<User>> getUsers(@Query("since") int since, @Query("page") int page,
                                        @Query("per_page") int amount);

}
