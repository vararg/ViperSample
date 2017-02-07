package com.vararg.vipersample.mainscreen.domain;

import com.vararg.vipersample.data.users.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by vararg on 27-01-17.
 */

public class UserMapper {

    public Collection<UserViewModel> map(Collection<User> in) {
        Collection<UserViewModel> out = new ArrayList(in.size());

        for (User user : in) {
            out.add(new UserViewModel(user.getId(), user.getLogin(),
                    user.getAvatarUrl(), user.getUrl()));
        }

        return out;
    }

}
