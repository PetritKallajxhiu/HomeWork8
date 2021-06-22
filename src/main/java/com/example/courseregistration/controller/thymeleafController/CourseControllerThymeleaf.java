package com.example.courseregistration.controller.thymeleafController;

import com.example.courseregistration.model.Course;
import com.example.courseregistration.model.Registration;
import com.example.courseregistration.service.CourseService;
import com.example.courseregistration.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseControllerThymeleaf {
    CourseService courseService;
    RegistrationService registrationService;

    public CourseControllerThymeleaf(CourseService courseService, RegistrationService registrationService) {
        this.courseService = courseService;
        this.registrationService = registrationService;
    }

    @GetMapping("/courses")
    public String getCourses(ModelMap modelMap) {
        var allCourses = this.courseService.getAll();
        modelMap.addAttribute("allCourses", allCourses);

        return "courses";
    }

    @RequestMapping("/register_course")
    public String registerCourse(final ModelMap modelMap) {
        var course = new Course();
        modelMap.addAttribute("course", course);

        List<Registration> registrations = registrationService.getAll();
        modelMap.addAttribute("registrations", registrations);

        return "registerCourse";
    }

    @PostMapping("/register")
    public String register(@Valid Course course, final ModelMap modelMap) {
        modelMap.addAttribute("course", course);

        List<Registration> registrations = registrationService.getAll();
        modelMap.addAttribute("registrations", registrations);

        courseService.save(course);

        return "success";
    }
}
