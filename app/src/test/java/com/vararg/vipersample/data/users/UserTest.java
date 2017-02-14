package com.vararg.vipersample.data.users;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by vararg on 14-02-17.
 */

public class UserTest {

    private static final long ID = 1;
    private static final String LOGIN = "qwerty";
    private static final String AVATAR_URL = "http://megapoisk.com/uploads/3795361471949756.png";
    private static final String URL = "https://ru.wikipedia.org/wiki/QWERTY";

    private User user;

    private Set<User> testUsers;

    @Before
    public void setUp() {
        user = new User(ID, LOGIN, AVATAR_URL, URL);
    }

    @Test
    public void testEquals() {
       assertThat(user).isEqualTo(user)
               .isEqualTo(new User(ID, LOGIN, AVATAR_URL, URL))
               .isNotEqualTo(new User(0, LOGIN, AVATAR_URL, URL))
               .isNotEqualTo(new User(ID, null, AVATAR_URL, URL))
               .isNotEqualTo(new User(ID, LOGIN, null, URL))
               .isNotEqualTo(new User(ID, LOGIN, AVATAR_URL, null));
    }

    @Test
    public void testHashCode() {
        assertThat(user.hashCode()).isEqualTo(new User(ID, LOGIN, AVATAR_URL, URL).hashCode());
    }

    @Test
    public void testProperties() {
        assertThat(user.getId()).isEqualTo(ID);
        assertThat(user.getLogin()).isEqualTo(LOGIN);
        assertThat(user.getAvatarUrl()).isEqualTo(AVATAR_URL);
        assertThat(user.getUrl()).isEqualTo(URL);
    }
}
