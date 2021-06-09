package com.example.courseregistration;

import com.example.courseregistration.controller.CourseController;
import com.example.courseregistration.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CourseRegistrationApplication {

    public static void main(String[] args) {
        ApplicationContext apx = SpringApplication.run(CourseRegistrationApplication.class, args);

        UserController userController = (UserController) apx.getBean("userController");

        System.out.println("************* Get all users *************");
//        userController.getUsers().forEach(System.out::println);

        System.out.println("************* Get user by Id *************");
//        System.out.println(userController.findById(1));

        System.out.println("************* Update users *************");
//        var user = userController.findById(1);
//        user.ifPresent(user1 -> {
//            user1.setFirstName("John");
//            user1.setLastName("Smith");
//            userController.updateUser(user1);
//        });

//        CourseController cc = (CourseController) apx.getBean("courseController");
//        cc.getCourses().forEach(System.out::println);
    }
}
