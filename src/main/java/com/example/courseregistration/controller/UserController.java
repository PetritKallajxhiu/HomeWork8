package com.example.courseregistration.controller;

import com.example.courseregistration.model.User;
import com.example.courseregistration.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody User request) {
        return userService.save(request);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public Optional<User> findById(@PathVariable int userId) {
        return userService.getById(userId);
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User requestUser) {
        return userService.save(requestUser);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable int userId) {
        userService.delete(userId);
    }
}
