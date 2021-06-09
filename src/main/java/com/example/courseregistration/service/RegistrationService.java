package com.example.courseregistration.service;

import com.example.courseregistration.model.Registration;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RegistrationService {
    Optional<Registration> getById(int id);

    List<Registration> getAll();

    void delete(int id);

    Registration save(Registration registration);
}
