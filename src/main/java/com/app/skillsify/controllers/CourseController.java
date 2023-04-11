package com.app.skillsify.controllers;

import com.app.skillsify.models.Course;
import com.app.skillsify.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
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
