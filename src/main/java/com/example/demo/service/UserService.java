package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User registerUser(User user);

    User findByEmail(String email);

    User findById(Long id);

    // Other CRUD operations (EMPTY)
    default void updateUser(Long id) {}
    default void deleteUser(Long id) {}
}
