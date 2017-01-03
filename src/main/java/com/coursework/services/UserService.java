package com.coursework.services;

import com.coursework.model.Ticket;
import com.coursework.model.User;
import com.coursework.repository.RoleRepository;
import com.coursework.repository.TicketRepository;
import com.coursework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean existUser(User user) {
        return userRepository.exists(user.getUserId());
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User findById(int id) {
        return userRepository.findOne(id);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteUserById(int id) {
        if (findById(id) != null) {
            userRepository.delete(id);
        }
    }

    public void updateUser(User user) {
        if (user.getTickets() != null) {
            for (Ticket t : user.getTickets()) {
                t.setIsSold(1);
                t.setUserId(user.getUserId());
            }
        }
        userRepository.saveAndFlush(user);
    }

    public void setDiscount(int userId, int discountId) {

    }

    public void addUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>((roleRepository.findByName("ROLE_USER"))));
        userRepository.save(user);
    }
}

