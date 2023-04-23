package com.app.skillsify.services;

import com.app.skillsify.models.CourseAnnouncement;

import java.util.List;

public interface CourseAnnouncementService {
    List<CourseAnnouncement> findAll();
}
