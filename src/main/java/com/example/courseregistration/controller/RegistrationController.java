package com.example.courseregistration.controller;

import com.example.courseregistration.model.Registration;
import com.example.courseregistration.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public Registration addRegistration(@RequestBody Registration request) {
        return registrationService.save(request);
    }

    @GetMapping("/{registrationId}")
    public Optional<Registration> getById(@PathVariable int registrationId) {
        return registrationService.getById(registrationId);
    }

    @GetMapping
    public List<Registration> getAll() {
        return registrationService.getAll();
    }

    @PutMapping
    public Registration update(@Valid @RequestBody Registration request) {
        return registrationService.save(request);
    }

    @DeleteMapping("/{registrationId}")
    public void deleteRegistration(@PathVariable int registrationId) {
        registrationService.delete(registrationId);
    }
}
