package com.spring.springcore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springcore.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
