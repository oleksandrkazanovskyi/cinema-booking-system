package com.kazanovskiy.cinema.services;

import com.kazanovskiy.cinema.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUsername(String userName);

    User findByEmail(String email);

    User findByPhone(String telephone);

    User findById(Long id);

    void delete(Long id);

    void update(User user);

    void add(User user);
}
