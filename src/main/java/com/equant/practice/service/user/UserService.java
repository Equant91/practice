package com.equant.practice.service.user;

import com.equant.practice.ResponseView;
import com.equant.practice.model.User;

public interface UserService {
    User findByID(long id);

    User findByName(String name);

    ResponseView update(User user);

    ResponseView add(User user);
}
