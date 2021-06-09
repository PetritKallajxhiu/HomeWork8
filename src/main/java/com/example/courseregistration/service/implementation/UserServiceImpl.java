package com.example.courseregistration.service.implementation;

import com.example.courseregistration.model.User;
import com.example.courseregistration.repository.UserRepository;
import com.example.courseregistration.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(int id) {
        var user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        userRepository.delete(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
