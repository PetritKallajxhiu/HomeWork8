package com.example.courseregistration.service.implementation;

import com.example.courseregistration.model.Course;
import com.example.courseregistration.repository.CourseRepository;
import com.example.courseregistration.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<Course> findById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public void delete(int id) {
        var course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        courseRepository.delete(course);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
