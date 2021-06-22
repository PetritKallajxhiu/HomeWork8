package com.example.courseregistration.controller.thymeleafController;

import com.example.courseregistration.model.User;
import com.example.courseregistration.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserControllerThymeleaf {
    UserService userService;

    public UserControllerThymeleaf(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(ModelMap modelMap) {
        var users = userService.getAll();
        modelMap.addAttribute("users", users);

        return "users";
    }

    @RequestMapping("/register_user")
    public String registerUser(final ModelMap modelMap) {
        var user = new User();
        modelMap.addAttribute("user", user);

        return "registerUser";
    }

    @PostMapping("/register_new_user")
    public String register(@Valid User user, final ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        userService.save(user);

        return "success";
    }
}
