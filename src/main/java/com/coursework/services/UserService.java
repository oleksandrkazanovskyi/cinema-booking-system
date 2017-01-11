package com.coursework.services;

import com.coursework.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User findByUsername(String userName);

    User findUserById(Integer id);

    void deleteUserById(Integer id);

    void updateUser(User user);

    void save(User user);
}
