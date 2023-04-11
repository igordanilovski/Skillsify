package com.app.skillsify.services;


import com.app.skillsify.models.Course;

import java.util.*;

public interface CourseService {
    List<Course> findAll();

    Optional<Course> findByName(String name);
    Optional<Course> findById(Long id);
}
