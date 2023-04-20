package com.app.skillsify.services;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.CourseAnnouncements;

import java.util.List;

public interface CourseAnnouncementService {
    List<CourseAnnouncements> findAll();
}
