package com.example.courseregistration.service;

import com.example.courseregistration.model.Course;

import java.util.List;
import java.util.Optional;


public interface CourseService {
    Optional<Course> findById(int id);

    List<Course> getAll();

    void delete(int id);

    Course save(Course course);
}
