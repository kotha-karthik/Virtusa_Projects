package com.iss.library.dao;

import com.iss.library.models.User;

public interface UserDao {
    User login(String username, String password);
    void register(User user);
}
