package com.vararg.vipersample.data.users;

/**
 * Created by vararg on 27-01-17.
 */

public class User {

    private long id;
    private String login;
    private String avatarUrl;
    private String url;

    public User(long id, String login, String avatarUrl, String url) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUrl() {
        return url;
    }
}
