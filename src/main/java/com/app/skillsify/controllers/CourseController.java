package com.app.skillsify.controllers;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.CourseAnnouncement;
import com.app.skillsify.services.CourseAnnouncementService;
import com.app.skillsify.services.CourseService;
import com.app.skillsify.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final CourseAnnouncementService courseAnnouncementService;
    private final UserService userService;

    public CourseController(CourseService courseService, CourseAnnouncementService courseAnnouncementService, UserService userService) {
        this.courseService = courseService;
        this.courseAnnouncementService = courseAnnouncementService;
        this.userService = userService;
    }


    @GetMapping("/test")
    public List<CourseAnnouncement> test() {
        return this.courseAnnouncementService.findAll();
    }

    @GetMapping
    public List<Course> findAllCourses() {
        return this.courseService.findAll();
    }

    @GetMapping("/{name}")
    public Optional<Course> findCourseByName(@PathVariable String name) {
        return this.courseService.findByName(name);
    }
}
