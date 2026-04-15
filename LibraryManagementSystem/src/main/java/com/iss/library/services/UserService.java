package com.iss.library.services;

import com.iss.library.dao.UserDAOImpl;
import com.iss.library.dao.UserDao;
import com.iss.library.exceptions.UserNotFoundException;
import com.iss.library.models.User;

public class UserService {
    private UserDao userDAO = new UserDAOImpl();


    public User login(String username, String password) {
        User user = userDAO.login(username, password);

        if (user == null) {
            throw new RuntimeException("Invalid username or password!");
        }

        return user;
    }

    public void registerStudent(User user) {

        if (user.getUsername() == null || user.getPassword() == null) {
            throw new UserNotFoundException("Username & Password required!");
        }

        if (!user.getRole().equals("STUDENT")) {
            throw new UserNotFoundException("Only student registration allowed!");
        }

        userDAO.register(user);
    }
}
