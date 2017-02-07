package com.coursework.repository;

import com.coursework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String userName);

    User findByEmail(String email);

    User findByTelephone(String telephone);
}

