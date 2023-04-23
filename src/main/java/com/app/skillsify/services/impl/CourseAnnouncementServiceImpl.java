package com.app.skillsify.services.impl;

import com.app.skillsify.models.CourseAnnouncement;
import com.app.skillsify.repositories.CourseAnnouncementsRepository;
import com.app.skillsify.services.CourseAnnouncementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAnnouncementServiceImpl implements CourseAnnouncementService {
    private final CourseAnnouncementsRepository courseAnnouncementsRepository;

    public CourseAnnouncementServiceImpl(CourseAnnouncementsRepository courseAnnouncementsRepository) {
        this.courseAnnouncementsRepository = courseAnnouncementsRepository;
    }

    @Override
    public List<CourseAnnouncement> findAll() {
        return this.courseAnnouncementsRepository.findAll();
    }
}
