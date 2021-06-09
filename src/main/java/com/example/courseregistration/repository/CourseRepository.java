package com.example.courseregistration.repository;

import com.example.courseregistration.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Integer> {
//    @Query("select u ")
//    public getByFirstName();
}
