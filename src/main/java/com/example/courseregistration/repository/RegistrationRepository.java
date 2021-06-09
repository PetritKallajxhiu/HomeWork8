package com.example.courseregistration.repository;

import com.example.courseregistration.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
