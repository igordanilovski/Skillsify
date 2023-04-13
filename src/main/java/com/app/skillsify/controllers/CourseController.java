package com.app.skillsify.controllers;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.User;
import com.app.skillsify.services.CourseService;
import com.app.skillsify.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final UserService userService;

    public CourseController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping
    public List<Course> getCourseByName() {
        return this.courseService.findAll();
    }

    @GetMapping("/{name}")
    public Optional<Course> getCourseByName(@PathVariable String name) {
        return this.courseService.findByName(name);
    }
}
