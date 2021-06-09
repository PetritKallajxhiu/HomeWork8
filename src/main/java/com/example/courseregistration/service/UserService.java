package com.example.courseregistration.service;

import com.example.courseregistration.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    Optional<User> getById(int id);

    List<User> getAll();

    void delete(int id);

    User save(User user);
}
