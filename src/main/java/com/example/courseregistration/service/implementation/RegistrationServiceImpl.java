package com.example.courseregistration.service.implementation;

import com.example.courseregistration.model.Registration;
import com.example.courseregistration.repository.RegistrationRepository;
import com.example.courseregistration.service.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public Optional<Registration> getById(int id) {
        return registrationRepository.findById(id);
    }

    @Override
    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }

    @Override
    public void delete(int id) {
        var registration = registrationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        registrationRepository.delete(registration);
    }

    @Override
    public Registration save(Registration registration) {
        return registrationRepository.save(registration);
    }
}
