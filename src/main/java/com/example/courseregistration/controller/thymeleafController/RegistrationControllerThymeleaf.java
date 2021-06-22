package com.example.courseregistration.controller.thymeleafController;

import com.example.courseregistration.model.Registration;
import com.example.courseregistration.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationControllerThymeleaf {
    RegistrationService registrationService;

    public RegistrationControllerThymeleaf(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/registrations")
    public String registrations(final ModelMap modelMap) {
        List<Registration> registrations = registrationService.getAll();
        modelMap.addAttribute("registrations", registrations);

        return "registrations";
    }

    @RequestMapping("/register_registration")
    public String registerRegistration(final ModelMap modelMap) {
        var registration = new Registration();
        modelMap.addAttribute("registration", registration);

        return "registerRegistrations";
    }

    @PostMapping("/register_new_registration")
    public String register(@Valid Registration registration, final ModelMap modelMap) {
        modelMap.addAttribute("registration", registration);
        registrationService.save(registration);

        return "success";
    }
}
