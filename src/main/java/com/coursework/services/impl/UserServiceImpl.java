package com.coursework.services.impl;

import com.coursework.model.Order;
import com.coursework.model.Role;
import com.coursework.model.Ticket;
import com.coursework.model.User;
import com.coursework.repository.RoleRepository;
import com.coursework.repository.TicketRepository;
import com.coursework.repository.UserRepository;
import com.coursework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByTelephone(String telephone) {
        return userRepository.findByTelephone(telephone);
    }

    public User findUserById(Integer id) {
        return userRepository.findOne(id);
    }

    public void deleteUserById(Integer id) {
        if (findUserById(id) != null) {
            userRepository.delete(id);
        }
    }

    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public void updateUser(User user, Order order) {
        if (user.getDiscount() != null) {
            for (Ticket t : order.getTickets()) {
                t.setPrice(t.getPrice() - ((t.getPrice() / 100) * user.getDiscount().getPercent()));
            }
        }
        user.getTickets().addAll(order.getTickets());
        if (user.getTickets() != null) {
            for (Ticket t : user.getTickets()) {
                t.setUserId(user.getUserId());
            }
        }
        userRepository.saveAndFlush(user);
    }

    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>((roleRepository.findByName("ROLE_USER"))));
        userRepository.save(user);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}

