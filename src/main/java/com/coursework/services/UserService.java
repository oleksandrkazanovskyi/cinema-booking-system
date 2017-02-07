package com.coursework.services;

import com.coursework.model.Order;
import com.coursework.model.Role;
import com.coursework.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User findByUsername(String userName);

    User findByEmail(String email);

    User findByTelephone(String telephone);

    User findUserById(Integer id);

    void deleteUserById(Integer id);

    void updateUser(User user);

    void updateUser(User user, Order order);

    void addUser(User user);

    List<Role> getAllRoles();
}
