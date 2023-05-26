package com.app.skillsify.controllers;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.dto.CourseDto;
import com.app.skillsify.models.dto.EnrollmentDto;
import com.app.skillsify.services.CourseAnnouncementService;
import com.app.skillsify.services.CourseService;
import com.app.skillsify.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
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

//    @GetMapping("/test")
//    public List<CourseAnnouncement> findAll() {
//        return this.courseAnnouncementService.findAll();
//    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok()
                .body(this.courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(this.courseService.findById(id));
    }

    @PostMapping
    private ResponseEntity<Course> create(@RequestBody CourseDto courseDto) {
        return ResponseEntity.ok().body(this.courseService.create(courseDto));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Course> edit(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        return ResponseEntity.ok().body(this.courseService.edit(id, courseDto));
    }

    @PostMapping("/delete/{id}")
    private void delete(@PathVariable Long id){
        this.courseService.deleteById(id);
    }

    @PostMapping("/enroll-user")
    private ResponseEntity<Course> enrollUser(@RequestBody EnrollmentDto enrollmentDto){
        return ResponseEntity.ok().body(this.courseService.enrollUser(enrollmentDto));
    }
}