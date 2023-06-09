package com.app.skillsify.services;


import com.app.skillsify.models.Course;
import com.app.skillsify.models.dto.CourseDto;
import com.app.skillsify.models.dto.EnrollmentDto;

import java.util.*;

public interface CourseService {
    List<Course> findAll();
    Optional<Course> findByName(String name);

    Optional<Course> findById(Long id);

    Course create(CourseDto courseDto);

    Course edit(Long id, CourseDto courseDto);

    Course enrollUser(EnrollmentDto enrollmentDto);

    void deleteById(Long id);
}
