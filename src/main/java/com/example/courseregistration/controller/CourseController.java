package com.example.courseregistration.controller;

import com.example.courseregistration.model.Course;
import com.example.courseregistration.service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course addCourse(@RequestBody Course request) {
        return courseService.save(request);
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAll();
    }

    @GetMapping("/{courseId}")
    public Optional<Course> findById(@PathVariable int courseId) {
        return courseService.findById(courseId);
    }

    @PutMapping
    public Course updateCourse(@Valid @RequestBody Course request) {
        return courseService.save(request);
    }

    @DeleteMapping("/{courseId}")
    public void delete(@PathVariable int courseId) {
        courseService.delete(courseId);
    }
}
